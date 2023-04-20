package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.Corporacao;
import br.com.magna.corporacaoapi.entity.entityHistoric.CorporacaoHistorico;
import br.com.magna.corporacaoapi.infra.exception.BadRequestExceptionHandler;
import br.com.magna.corporacaoapi.repository.AtividadeComercialRepository;
import br.com.magna.corporacaoapi.repository.CorporacaoRepository;
import br.com.magna.corporacaoapi.repository.InstituicaoRepository;
import br.com.magna.corporacaoapi.repository.NaturezaJuridicaRepository;
import br.com.magna.corporacaoapi.repository.PorteRepository;
import br.com.magna.corporacaoapi.repository.SedeRepository;
import br.com.magna.corporacaoapi.repository.repositoryHistoric.CorporacaoRepositoryHistorico;
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
	private CorporacaoRepositoryHistorico corporacaoRepositoryHistoric;

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

	private String dbUser = "Admin";

	private String dbUser2 = "Admin2";

	public Corporacao cadastrarCorporacao(Corporacao dados) {

		Corporacao corporacao = new Corporacao();

		corporacao.setCnpj(dados.getCnpj());
		corporacao.setRazaoSocial(dados.getRazaoSocial());
		corporacao.setNomeFantasia(dados.getNomeFantasia());
		corporacao.setTipoPublico(dados.getTipoPublico());
		corporacao.setMultinacional(dados.getMultinacional());
		corporacao.setFaturamento(dados.getFaturamento());
		corporacao.setNumFuncionarios(dados.getNumFuncionarios());

		var instituicao = instituicaoService.cadastrarInstituicao(dados.getInstituicao());
		corporacao.setInstituicao(instituicao);

		var porte = porteService.cadastrarPorte(dados.getPorte());
		corporacao.setPorte(porte);

		var atividadeComercial = atividadeComercialService.cadastrarAtividadeComercial(dados.getAtividadeComercial());
		corporacao.setAtividadeComercial(atividadeComercial);

		var naturezaJuridica = naturezaJuridicaService.cadastrarNaturezaJuridica(dados.getNaturezaJuridica());
		corporacao.setNaturezaJuridica(naturezaJuridica);

		var sede = sedeService.cadastrarSede(dados.getSede());
		corporacao.setSede(sede);

		corporacao.setUserDatabaseCreate(dbUser);

		corporacao.setUserDatabaseUpdate(dbUser);

		corporacao.setTimestampFirstCreated(ZonedDateTime.now());

		corporacao.setTimestampLastUpdate(ZonedDateTime.now());

		corporacao.setTimestampTimeZone(ZonedDateTime.now().getZone());

		Corporacao retorno = corporacaoRepository.save(corporacao);
		corporacaoRepositoryHistoric.save(cadastrarCorporacaoHistorico(retorno));

		return corporacao;
	}

	public Corporacao atualizarCorporacao(@Valid Corporacao dados) {

		var corporacao = corporacaoRepository.getReferenceById(dados.getId());
		CorporacaoHistorico corporacaoHistoric = cadastrarCorporacaoHistorico(corporacao);
		corporacaoRepositoryHistoric.save(corporacaoHistoric);

		if (dados.getNomeFantasia() != null) {
			corporacao.setNomeFantasia(dados.getNomeFantasia());
		}
		if (dados.getTipoPublico() != null) {
			corporacao.setTipoPublico(dados.getTipoPublico());
		}
		if (dados.getMultinacional() != null) {
			corporacao.setMultinacional(dados.getMultinacional());
		}
		if (dados.getFaturamento() != null) {
			corporacao.setFaturamento(dados.getFaturamento());
		}
		if (dados.getNumFuncionarios() != null) {
			corporacao.setNumFuncionarios(dados.getNumFuncionarios());
		}

		instituicaoService.atualizarInstituicao(dados.getInstituicao());

		porteService.atualizarPorte(dados.getPorte());

		atividadeComercialService.atualizarAtividadeComercial(dados.getAtividadeComercial());

		naturezaJuridicaService.atualizarNaturezaJuridica(dados.getNaturezaJuridica());

		sedeService.atualizarSede(dados.getSede());

		corporacao.setUserDatabaseCreate(dbUser);

		corporacao.setUserDatabaseUpdate(dbUser2);

		corporacao.setTimestampLastUpdate(ZonedDateTime.now());

		corporacaoRepository.save(corporacao);

		return corporacao;
	}

	public Page<Corporacao> listarCorporacoes(Pageable pageable) {
		return corporacaoRepository.findAll(pageable).map(c -> c);
	}

	public Page<Corporacao> listarCnpjAtivo(Pageable pageable) {
		return corporacaoRepository.findAllByCnpjAtivoTrue(pageable).map(c -> c);
	}

	public Corporacao listarPorID(Long id) {
		Optional<Corporacao> get = corporacaoRepository.findById(id).map(corporacao -> corporacao);

		return get.orElseThrow(BadRequestExceptionHandler::new);
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

	public CorporacaoHistorico cadastrarCorporacaoHistorico(Corporacao corporacao) {
		CorporacaoHistorico corporacaoHistorico = new CorporacaoHistorico();

		corporacaoHistorico.setIdCorporacao(corporacao.getId());
		corporacaoHistorico.setCnpj(corporacao.getCnpj());
		corporacaoHistorico.setRazaoSocial(corporacao.getRazaoSocial());
		corporacaoHistorico.setNomeFantasia(corporacao.getNomeFantasia());
		corporacaoHistorico.setTipoPublico(corporacao.getTipoPublico());
		corporacaoHistorico.setMultinacional(corporacao.getMultinacional());
		corporacaoHistorico.setFaturamento(corporacao.getFaturamento());
		corporacaoHistorico.setNumFuncionarios(corporacao.getNumFuncionarios());

		corporacaoHistorico
				.setInstituicao(instituicaoService.cadastrarInstituicaoHistorico(corporacao.getInstituicao()));

		corporacaoHistorico.setPorte(porteService.cadastrarPorteHistorico(corporacao.getPorte()));

		corporacaoHistorico.setAtividadeComercial(
				atividadeComercialService.cadastrarAtividadeComercialHistorico(corporacao.getAtividadeComercial()));

		corporacaoHistorico.setNaturezaJuridica(
				naturezaJuridicaService.cadastrarNaturezaJuridicaHistorico(corporacao.getNaturezaJuridica()));

		corporacaoHistorico.setSede(sedeService.cadastrarSedeHistorioco(corporacao.getSede()));

		corporacaoHistorico.setUserDatabaseCreate(corporacao.getUserDatabaseCreate());

		corporacaoHistorico.setUserDatabaseUpdate(dbUser2);

		corporacaoHistorico.setTimestampFirstCreated(corporacao.getTimestampFirstCreated());

		corporacaoHistorico.setTimestampLastUpdate(ZonedDateTime.now());

		corporacaoHistorico.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return corporacaoHistorico;
	}

}
