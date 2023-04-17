package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.NaturezaJuridica;
import br.com.magna.corporacaoapi.entity.entityHistoric.NaturezaJuridicaHistorico;
import br.com.magna.corporacaoapi.record.atualizarcorporacao.DadosAtualizarNaturezaJuridica;
import br.com.magna.corporacaoapi.record.cadastrarcorporacao.DadosCadastrarNaturezaJuridica;
import br.com.magna.corporacaoapi.repository.NaturezaJuridicaRepository;
import jakarta.validation.Valid;

@Service
public class NaturezaJuridicaService {

	@Autowired
	private NaturezaJuridicaRepository naturezaJuridicaRepository;

	private String dbUser = "Admin";

	private String dbUser2 = "Admin2";

	public NaturezaJuridica cadastrarNaturezaJuridica(DadosCadastrarNaturezaJuridica dados) {
		NaturezaJuridica naturezaJuridica = new NaturezaJuridica();
		naturezaJuridica.setCodigoNaturezaJuridica(dados.codigoNaturezaJuridica());
		naturezaJuridica.setDescricaoNaturezaJuridica(dados.descricaoNaturezaJuridica());

		naturezaJuridica.setUserDatabaseCreate(dbUser);

		naturezaJuridica.setUserDatabaseUpdate(dbUser2);

		naturezaJuridica.setTimestampFirstCreated(ZonedDateTime.now());

		naturezaJuridica.setTimestampLastUpdate(ZonedDateTime.now());

		naturezaJuridica.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return naturezaJuridica;
	}

	public NaturezaJuridica atualizarNaturezaJuridica(@Valid DadosAtualizarNaturezaJuridica dados) {

		var naturezaJuridica = naturezaJuridicaRepository.getReferenceById(dados.id());

		if (dados.codigoNaturezaJuridica() != null) {
			naturezaJuridica.setCodigoNaturezaJuridica(dados.codigoNaturezaJuridica());
		}
		if (dados.descricaoNaturezaJuridica() != null) {
			naturezaJuridica.setDescricaoNaturezaJuridica(dados.descricaoNaturezaJuridica());
		}

		naturezaJuridica.setUserDatabaseCreate(dbUser);

		naturezaJuridica.setUserDatabaseUpdate(dbUser2);

		naturezaJuridica.setTimestampLastUpdate(ZonedDateTime.now());

		return naturezaJuridica;
	}

	public NaturezaJuridicaHistorico cadastrarNaturezaJuridicaHistorico(NaturezaJuridica naturezaJuridica) {
		NaturezaJuridicaHistorico naturezaJuridicaHistorico = new NaturezaJuridicaHistorico();
		
		naturezaJuridicaHistorico.setCodigoNaturezaJuridica(naturezaJuridica.getCodigoNaturezaJuridica());
		naturezaJuridicaHistorico.setDescricaoNaturezaJuridica(naturezaJuridica.getDescricaoNaturezaJuridica());

		naturezaJuridicaHistorico.setUserDatabaseCreate(naturezaJuridica.getUserDatabaseCreate());

		naturezaJuridicaHistorico.setUserDatabaseUpdate(dbUser2);

		naturezaJuridicaHistorico.setTimestampFirstCreated(naturezaJuridica.getTimestampFirstCreated());

		naturezaJuridicaHistorico.setTimestampLastUpdate(ZonedDateTime.now());

		naturezaJuridicaHistorico.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return naturezaJuridicaHistorico;
	}
}
