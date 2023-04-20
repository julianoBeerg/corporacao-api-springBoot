package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.NaturezaJuridica;
import br.com.magna.corporacaoapi.entity.entityHistoric.NaturezaJuridicaHistorico;
import br.com.magna.corporacaoapi.repository.NaturezaJuridicaRepository;
import jakarta.validation.Valid;

@Service
public class NaturezaJuridicaService {

	@Autowired
	private NaturezaJuridicaRepository naturezaJuridicaRepository;

	private String dbUser = "Admin";

	private String dbUser2 = "Admin2";

	public NaturezaJuridica cadastrarNaturezaJuridica(NaturezaJuridica dados) {
		NaturezaJuridica naturezaJuridica = new NaturezaJuridica();
		naturezaJuridica.setCodigoNaturezaJuridica(dados.getCodigoNaturezaJuridica());
		naturezaJuridica.setDescricaoNaturezaJuridica(dados.getDescricaoNaturezaJuridica());

		naturezaJuridica.setUserDatabaseCreate(dbUser);

		naturezaJuridica.setUserDatabaseUpdate(dbUser2);

		naturezaJuridica.setTimestampFirstCreated(ZonedDateTime.now());

		naturezaJuridica.setTimestampLastUpdate(ZonedDateTime.now());

		naturezaJuridica.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return naturezaJuridica;
	}

	public NaturezaJuridica atualizarNaturezaJuridica(@Valid NaturezaJuridica dados) {

		var naturezaJuridica = naturezaJuridicaRepository.getReferenceById(dados.getId());

		if (dados.getCodigoNaturezaJuridica() != null) {
			naturezaJuridica.setCodigoNaturezaJuridica(dados.getCodigoNaturezaJuridica());
		}
		if (dados.getDescricaoNaturezaJuridica() != null) {
			naturezaJuridica.setDescricaoNaturezaJuridica(dados.getDescricaoNaturezaJuridica());
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
