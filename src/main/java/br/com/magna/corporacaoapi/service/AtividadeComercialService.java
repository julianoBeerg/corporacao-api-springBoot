package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.AtividadeComercial;
import br.com.magna.corporacaoapi.entity.entityHistoric.AtividadeComercialHistorico;
import br.com.magna.corporacaoapi.record.atualizarcorporacao.DadosAtualizarAtividadeComercial;
import br.com.magna.corporacaoapi.record.cadastrarcorporacao.DadosCadastrarAtividadeComercial;
import br.com.magna.corporacaoapi.repository.AtividadeComercialRepository;
import jakarta.validation.Valid;

@Service
public class AtividadeComercialService {

	@Autowired
	private AtividadeComercialRepository atividadeComercialRepository;

	private String dbUser = "Admin";
	private String dbUser2 = "Admin2";

	public AtividadeComercial cadastrarAtividadeComercial(DadosCadastrarAtividadeComercial dados) {
		AtividadeComercial atividadeComercial = new AtividadeComercial();
		atividadeComercial.setCodigoAtividadeComercial(dados.codigoAtividadeComercial());
		atividadeComercial.setDescricaoAtividadeComercial(dados.descricaoAtividadeComercial());

		atividadeComercial.setUserDatabaseCreate(dbUser);

		atividadeComercial.setUserDatabaseUpdate(dbUser);

		atividadeComercial.setTimestampFirstCreated(ZonedDateTime.now());

		atividadeComercial.setTimestampLastUpdate(ZonedDateTime.now());

		atividadeComercial.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return atividadeComercial;
	}

	public AtividadeComercial atualizarAtividadeComercial(@Valid DadosAtualizarAtividadeComercial dados) {

		var atividadeComercial = atividadeComercialRepository.getReferenceById(dados.id());

		if (dados.codigoAtividadeComercial() != null) {
			atividadeComercial.setCodigoAtividadeComercial(dados.codigoAtividadeComercial());
		}
		if (dados.descricaoAtividadeComercial() != null) {
			atividadeComercial.setDescricaoAtividadeComercial(dados.descricaoAtividadeComercial());
		}

		atividadeComercial.setUserDatabaseCreate(dbUser);

		atividadeComercial.setUserDatabaseUpdate(dbUser2);

		atividadeComercial.setTimestampLastUpdate(ZonedDateTime.now());

		return atividadeComercial;
	}

	public AtividadeComercialHistorico cadastrarAtividadeComercialHistorico(AtividadeComercial atividadeComercial) {
		AtividadeComercialHistorico atividadeComercialHistorico = new AtividadeComercialHistorico();
		atividadeComercialHistorico.setCodigoAtividadeComercial(atividadeComercial.getCodigoAtividadeComercial());
		atividadeComercialHistorico.setDescricaoAtividadeComercial(atividadeComercial.getDescricaoAtividadeComercial());

		atividadeComercialHistorico.setUserDatabaseCreate(atividadeComercial.getUserDatabaseCreate());

		atividadeComercialHistorico.setUserDatabaseUpdate(dbUser2);

		atividadeComercialHistorico.setTimestampFirstCreated(atividadeComercial.getTimestampFirstCreated());

		atividadeComercialHistorico.setTimestampLastUpdate(ZonedDateTime.now());

		atividadeComercialHistorico.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return atividadeComercialHistorico;
	}
}
