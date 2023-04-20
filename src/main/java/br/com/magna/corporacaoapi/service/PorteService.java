package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.Porte;
import br.com.magna.corporacaoapi.entity.entityHistoric.PorteHistorico;
import br.com.magna.corporacaoapi.repository.PorteRepository;

@Service
public class PorteService {

	@Autowired
	private PorteRepository porteRepository;

	private String dbUser = "Admin";

	private String dbUser2 = "Admin2";

	public Porte cadastrarPorte(Porte dados) {
		Porte porte = new Porte();
		porte.setTipoPorte(dados.getTipoPorte());

		porte.setUserDatabaseCreate(dbUser);

		porte.setUserDatabaseUpdate(dbUser);

		porte.setTimestampFirstCreated(ZonedDateTime.now());

		porte.setTimestampLastUpdate(ZonedDateTime.now());

		porte.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return porte;
	}

	public Porte atualizarPorte(Porte dados) {

		var porte = porteRepository.getReferenceById(dados.getId());

		if (dados.getTipoPorte() != null) {
			porte.setTipoPorte(dados.getTipoPorte());
		}

		porte.setUserDatabaseCreate(dbUser);

		porte.setUserDatabaseUpdate(dbUser2);

		porte.setTimestampLastUpdate(ZonedDateTime.now());

		return porte;
	}

	public PorteHistorico cadastrarPorteHistorico(Porte porte) {
		PorteHistorico porteHistorico = new PorteHistorico();

		porteHistorico.setTipoPorte(porte.getTipoPorte());

		porteHistorico.setUserDatabaseCreate(porte.getUserDatabaseCreate());

		porteHistorico.setUserDatabaseUpdate(dbUser2);

		porteHistorico.setTimestampFirstCreated(porte.getTimestampFirstCreated());

		porteHistorico.setTimestampLastUpdate(ZonedDateTime.now());

		porteHistorico.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return porteHistorico;
	}
}
