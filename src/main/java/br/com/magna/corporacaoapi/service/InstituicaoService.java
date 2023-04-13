package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.Instituicao;
import br.com.magna.corporacaoapi.entity.entityHistoric.InstituicaoHistoric;
import br.com.magna.corporacaoapi.record.DadosAtualizarInstituicao;
import br.com.magna.corporacaoapi.record.DadosCadastrarInstituicao;
import br.com.magna.corporacaoapi.repository.InstituicaoRepository;
import jakarta.validation.Valid;

@Service
public class InstituicaoService {

	@Autowired
	private InstituicaoRepository instituicaoRepository;

	public Instituicao cadastrarInstituicao(DadosCadastrarInstituicao dados) {
		Instituicao instituicao = new Instituicao();
		instituicao.setTipoInstituicao(dados.tipoInstituicao());
		instituicao.setFundador(dados.fundador());
		instituicao.setDataFundacao(dados.dataFundacao());
		instituicao.setPresidente(dados.presidente());
		instituicao.setRepresentante(dados.representante());
		instituicao.setDiretor(dados.diretor());

		instituicao.setUserDatabase("admin");

		instituicao.setTimeStampFirstCreated(ZonedDateTime.now());

		instituicao.setTimeStampLastUpdate(ZonedDateTime.now());

		return instituicao;
	}

	public Instituicao atualizarInstituicao(@Valid DadosAtualizarInstituicao dados) {

		var instituicao = instituicaoRepository.getReferenceById(dados.id());

		if (dados.presidente() != null) {
			instituicao.setPresidente(dados.presidente());
		}
		if (dados.representante() != null) {
			instituicao.setRepresentante(dados.representante());
		}
		if (dados.diretor() != null) {
			instituicao.setDiretor(dados.diretor());
		}
		
		instituicao.setUserDatabase("admin");

		instituicao.setTimeStampFirstCreated(instituicao.getTimeStampFirstCreated());

		instituicao.setTimeStampLastUpdate(ZonedDateTime.now());

		return instituicao;
	}

	public InstituicaoHistoric cadastrarInstituicaoHistorico(Instituicao dados) {
		InstituicaoHistoric instituicao = new InstituicaoHistoric();
		instituicao.setTipoInstituicao(dados.getTipoInstituicao());
		instituicao.setFundador(dados.getFundador());
		instituicao.setDataFundacao(dados.getDataFundacao());
		instituicao.setPresidente(dados.getPresidente());
		instituicao.setRepresentante(dados.getRepresentante());
		instituicao.setDiretor(dados.getDiretor());
		
		instituicao.setUserDatabase("admin");

		instituicao.setTimeStampFirstCreated(ZonedDateTime.now());

		instituicao.setTimeStampLastUpdate(ZonedDateTime.now());

		return instituicao;
	}
}
