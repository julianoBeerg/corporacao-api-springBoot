package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.Corporacao;
import br.com.magna.corporacaoapi.entity.entityHistoric.CorporacaoHistoric;
import br.com.magna.corporacaoapi.record.DadosAtualizarCorporacao;
import br.com.magna.corporacaoapi.record.DadosCadastrarCorporacao;
import br.com.magna.corporacaoapi.record.DadosListarCorporacao;
import br.com.magna.corporacaoapi.repository.AtividadeComercialRepository;
import br.com.magna.corporacaoapi.repository.CorporacaoRepository;
import br.com.magna.corporacaoapi.repository.InstituicaoRepository;
import br.com.magna.corporacaoapi.repository.NaturezaJuridicaRepository;
import br.com.magna.corporacaoapi.repository.PorteRepository;
import br.com.magna.corporacaoapi.repository.SedeRepository;
import br.com.magna.corporacaoapi.repository.repositoryHistoric.CorporacaoRepositoryHistoric;
import jakarta.validation.Valid;

@Service
public class CorporacaoService {

	@Autowired
	private InstituicaoService instituicaoService;

	@Autowired
	private PorteService porteService;

	@Autowired
	private AtividadeComercialService atividadeComercialService;

	@Autowired
	private NaturezaJuridicaService naturezaJuridicaService;

	@Autowired
	private SedeService sedeService;

	@Autowired
	private CorporacaoRepository corporacaoRepository;

	@Autowired
	private CorporacaoRepositoryHistoric corporacaoRepositoryHistoric;

	@Autowired
	private InstituicaoRepository instituicaoRepository;

	@Autowired
	private PorteRepository porteRepository;

	@Autowired
	private AtividadeComercialRepository atividadeComercialRepository;

	@Autowired
	private NaturezaJuridicaRepository naturezaJuridicaRepository;

	@Autowired
	private SedeRepository sedeRepository;
	
	private String db_user = "Admin";

	public Corporacao cadastrarCorporacao(DadosCadastrarCorporacao dados) {
		Corporacao corporacao = new Corporacao();
		corporacao.setCnpj(dados.cnpj());
		corporacao.setRazaoSocial(dados.razaoSocial());
		corporacao.setNomeFantasia(dados.nomeFantasia());
		corporacao.setTipoPublico(dados.tipoPublico());
		corporacao.setMultinacional(dados.multinacional());
		corporacao.setFaturamento(dados.faturamento());
		corporacao.setNumFuncionarios(dados.numFuncionarios());

		var instituicao = instituicaoService.cadastrarInstituicao(dados.dadosCadastrarInstituicao());
		corporacao.setInstituicao(instituicao);

		var porte = porteService.cadastrarPorte(dados.dadosCadastrarPorte());
		corporacao.setPorte(porte);

		var atividadeComercial = atividadeComercialService
				.cadastrarAtividadeComercial(dados.dadosCadastrarAtividadeComercial());
		corporacao.setAtividadeComercial(atividadeComercial);

		var naturezaJuridica = naturezaJuridicaService
				.cadastrarNaturezaJuridica(dados.dadosCadastrarNaturezaJuridica());
		corporacao.setNaturezaJuridica(naturezaJuridica);

		var sede = sedeService.cadastrarSede(dados.dadosCadastrarSede());
		corporacao.setSede(sede);

		corporacao.setUserDatabase(db_user);

		corporacao.setTimeStampFirstCreated(ZonedDateTime.now());

		corporacao.setTimeStampLastUpdate(ZonedDateTime.now());

		corporacaoRepository.save(corporacao);

		CorporacaoHistoric corporacaoHistoric = cadastrarCorporacaoHistotico(corporacao);
		corporacaoRepositoryHistoric.save(corporacaoHistoric);

		return corporacao;
	}

	public Corporacao atualizarCorporacao(@Valid DadosAtualizarCorporacao dados) {

		var corporacao = corporacaoRepository.getReferenceById(dados.id());
		CorporacaoHistoric corporacaoHistoric = cadastrarCorporacaoHistotico(corporacao);
		corporacaoRepositoryHistoric.save(corporacaoHistoric);

		if (dados.nomeFantasia() != null) {
			corporacao.setNomeFantasia(dados.nomeFantasia());
		}
		if (dados.tipoPublico() != null) {
			corporacao.setTipoPublico(dados.tipoPublico());
		}
		if (dados.multinacional() != null) {
			corporacao.setMultinacional(dados.multinacional());
		}
		if (dados.faturamento() != null) {
			corporacao.setFaturamento(dados.faturamento());
		}
		if (dados.numFuncionarios() != null) {
			corporacao.setNumFuncionarios(dados.numFuncionarios());
		}

		instituicaoService.atualizarInstituicao(dados.dadosAtualizarInstituicao());

		porteService.atualizarPorte(dados.dadosAtualizarPorte());

		atividadeComercialService.atualizarAtividadeComercial(dados.dadosAtualizarAtividadeComercial());

		naturezaJuridicaService.atualizarNaturezaJuridica(dados.dadosAtualizarNaturezaJuridica());

		sedeService.atualizarSede(dados.dadosAtualizarSede());

		corporacao.setUserDatabase(db_user);

		corporacao.setTimeStampLastUpdate(ZonedDateTime.now());

		corporacaoRepository.save(corporacao);

		return corporacao;
	}

	public Page<DadosListarCorporacao> listarCorporacoes(Pageable pageable) {
		return corporacaoRepository.findAll(pageable).map(DadosListarCorporacao::new);
	}

	public Page<DadosListarCorporacao> listarCnpjAtivo(Pageable pageable) {
		return corporacaoRepository.findAllByCnpjAtivoTrue(pageable).map(DadosListarCorporacao::new);
	}

	public Corporacao listarPorId(Long id) {
		return corporacaoRepository.getReferenceById(id);
	}

	public void ativarCnpj(Long id) {
		Corporacao corporacao = corporacaoRepository.getReferenceById(id);
		corporacao.setCnpjAtivo(true);
	}

	public void inativarCnpj(Long id) {
		Corporacao corporacao = corporacaoRepository.getReferenceById(id);
		corporacao.setCnpjAtivo(false);
	}

	public void excluirCorporacao(Long id) {
		corporacaoRepository.deleteById(id);
		instituicaoRepository.deleteById(id);
		porteRepository.deleteById(id);
		atividadeComercialRepository.deleteById(id);
		naturezaJuridicaRepository.deleteById(id);
		sedeRepository.deleteById(id);

	}

	public CorporacaoHistoric cadastrarCorporacaoHistotico(Corporacao corporacao) {
		CorporacaoHistoric corporacaoHistoric = new CorporacaoHistoric();

		corporacaoHistoric.setIdCorporacao(corporacao.getId());

		corporacaoHistoric.setCnpj(corporacao.getCnpj());
		corporacaoHistoric.setRazaoSocial(corporacao.getRazaoSocial());
		corporacaoHistoric.setNomeFantasia(corporacao.getNomeFantasia());
		corporacaoHistoric.setTipoPublico(corporacao.getTipoPublico());
		corporacaoHistoric.setMultinacional(corporacao.getMultinacional());
		corporacaoHistoric.setFaturamento(corporacao.getFaturamento());
		corporacaoHistoric.setNumFuncionarios(corporacao.getNumFuncionarios());

		corporacaoHistoric
				.setInstituicao(instituicaoService.cadastrarInstituicaoHistorico(corporacao.getInstituicao()));

		corporacaoHistoric.setPorte(porteService.cadastrarPorteHistorico(corporacao.getPorte()));

		corporacaoHistoric.setAtividadeComercial(
				atividadeComercialService.cadastrarAtividadeComercialHistorico(corporacao.getAtividadeComercial()));

		corporacaoHistoric.setNaturezaJuridica(
				naturezaJuridicaService.cadastrarNaturezaJuridicaHistorico(corporacao.getNaturezaJuridica()));

		corporacaoHistoric.setSede(sedeService.cadastrarSedeHistorioco(corporacao.getSede()));

		corporacaoHistoric.setUserDatabase(db_user);

		corporacaoHistoric.setTimeStampFirstCreated(corporacao.getTimeStampFirstCreated());

		corporacaoHistoric.setTimeStampLastUpdate(ZonedDateTime.now());

		return corporacaoHistoric;

	}

}
