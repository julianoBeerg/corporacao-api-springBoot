package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.Instituicao;
import br.com.magna.corporacaoapi.entity.entityHistoric.InstituicaoHistorico;
import br.com.magna.corporacaoapi.record.atualizarcorporacao.DadosAtualizarInstituicao;
import br.com.magna.corporacaoapi.record.cadastrarcorporacao.DadosCadastrarInstituicao;
import br.com.magna.corporacaoapi.repository.InstituicaoRepository;
import jakarta.validation.Valid;

@Service
public class InstituicaoService {

	@Autowired
	private InstituicaoRepository instituicaoRepository;

	private String dbUser = "Admin";

	private String dbUser2 = "Admin2";

	public Instituicao cadastrarInstituicao(DadosCadastrarInstituicao dados) {
		Instituicao instituicao = new Instituicao();
		instituicao.setTipoInstituicao(dados.tipoInstituicao());
		instituicao.setFundador(dados.fundador());
		instituicao.setDataFundacao(dados.dataFundacao());
		instituicao.setPresidente(dados.presidente());
		instituicao.setRepresentante(dados.representante());
		instituicao.setDiretor(dados.diretor());

		instituicao.setUserDatabaseCreate(dbUser);

		instituicao.setUserDatabaseUpdate(dbUser2);

		instituicao.setTimestampFirstCreated(ZonedDateTime.now());

		instituicao.setTimestampLastUpdate(ZonedDateTime.now());

		instituicao.setTimestampTimeZone(ZonedDateTime.now().getZone());

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
