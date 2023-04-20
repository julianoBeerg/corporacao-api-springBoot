package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.Instituicao;
import br.com.magna.corporacaoapi.entity.entityHistoric.InstituicaoHistorico;
import br.com.magna.corporacaoapi.repository.InstituicaoRepository;
import jakarta.validation.Valid;

@Service
public class InstituicaoService {

	@Autowired
	private InstituicaoRepository instituicaoRepository;

	private String dbUser = "Admin";

	private String dbUser2 = "Admin2";

	public Instituicao cadastrarInstituicao(Instituicao dados) {
		Instituicao instituicao = new Instituicao();
		instituicao.setTipoInstituicao(dados.getTipoInstituicao());
		instituicao.setFundador(dados.getFundador());
		instituicao.setDataFundacao(dados.getDataFundacao());
		instituicao.setPresidente(dados.getPresidente());
		instituicao.setRepresentante(dados.getRepresentante());
		instituicao.setDiretor(dados.getDiretor());

		instituicao.setUserDatabaseCreate(dbUser);

		instituicao.setUserDatabaseUpdate(dbUser2);

		instituicao.setTimestampFirstCreated(ZonedDateTime.now());

		instituicao.setTimestampLastUpdate(ZonedDateTime.now());

		instituicao.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return instituicao;
	}

	public Instituicao atualizarInstituicao(@Valid Instituicao dados) {

		var instituicao = instituicaoRepository.getReferenceById(dados.getId());

		if (dados.getPresidente() != null) {
			instituicao.setPresidente(dados.getPresidente());
		}
		if (dados.getRepresentante() != null) {
			instituicao.setRepresentante(dados.getRepresentante());
		}
		if (dados.getDiretor() != null) {
			instituicao.setDiretor(dados.getDiretor());
		}
		instituicao.setUserDatabaseCreate(dbUser);

		instituicao.setUserDatabaseUpdate(dbUser2);

		instituicao.setTimestampLastUpdate(ZonedDateTime.now());

		return instituicao;
	}

	public InstituicaoHistorico cadastrarInstituicaoHistorico(Instituicao instituicao) {

		InstituicaoHistorico instituicaoHistorico = new InstituicaoHistorico();

		instituicaoHistorico.setTipoInstituicao(instituicao.getTipoInstituicao());
		instituicaoHistorico.setFundador(instituicao.getFundador());
		instituicaoHistorico.setDataFundacao(instituicao.getDataFundacao());
		instituicaoHistorico.setPresidente(instituicao.getPresidente());
		instituicaoHistorico.setRepresentante(instituicao.getRepresentante());
		instituicaoHistorico.setDiretor(instituicao.getDiretor());

		instituicaoHistorico.setUserDatabaseCreate(dbUser);

		instituicaoHistorico.setUserDatabaseUpdate(dbUser2);

		instituicaoHistorico.setTimestampFirstCreated(instituicao.getTimestampFirstCreated());

		instituicaoHistorico.setTimestampLastUpdate(ZonedDateTime.now());

		instituicaoHistorico.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return instituicaoHistorico;
	}
}
