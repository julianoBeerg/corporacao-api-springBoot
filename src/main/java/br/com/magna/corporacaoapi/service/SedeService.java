package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.Sede;
import br.com.magna.corporacaoapi.entity.entityHistoric.SedeHistorico;
import br.com.magna.corporacaoapi.repository.SedeRepository;

@Service
public class SedeService {

	@Autowired
	private SedeRepository sedeRepository;

	private String dbUser = "Admin";

	private String dbUser2 = "Admin2";

	public Sede cadastrarSede(Sede dados) {
		Sede sede = new Sede();
		sede.setPais(dados.getPais());
		sede.setUf(dados.getUf());
		sede.setCidade(dados.getCidade());
		sede.setLogradouro(dados.getLogradouro());
		sede.setNumero(dados.getNumero());
		sede.setCep(dados.getCep());
		sede.setComplemento(dados.getComplemento());

		sede.setUserDatabaseCreate(dbUser);

		sede.setUserDatabaseUpdate(dbUser);

		sede.setTimestampFirstCreated(ZonedDateTime.now());

		sede.setTimestampLastUpdate(ZonedDateTime.now());

		sede.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return sede;
	}

	public Sede atualizarSede(Sede dados) {

		var sede = sedeRepository.getReferenceById(dados.getId());

		if (dados.getPais() != null) {
			sede.setPais(dados.getPais());
		}
		if (dados.getUf() != null) {
			sede.setUf(dados.getUf());
		}
		if (dados.getCidade() != null) {
			sede.setCidade(dados.getCidade());
		}
		if (dados.getLogradouro() != null) {
			sede.setLogradouro(dados.getLogradouro());
		}
		if (dados.getNumero() != null) {
			sede.setNumero(dados.getNumero());
		}
		if (dados.getCep() != null) {
			sede.setCep(dados.getCep());
		}
		if (dados.getComplemento() != null) {
			sede.setComplemento(dados.getComplemento());
		}
		
		sede.setUserDatabaseCreate(dbUser);

		sede.setUserDatabaseUpdate(dbUser2);

		sede.setTimestampLastUpdate(ZonedDateTime.now());

		return sede;
	}

	public SedeHistorico cadastrarSedeHistorioco(Sede sede) {
		SedeHistorico sedeHistorico = new SedeHistorico();
		
		sedeHistorico.setPais(sede.getPais());
		sedeHistorico.setUf(sede.getUf());
		sedeHistorico.setCidade(sede.getCidade());
		sedeHistorico.setLogradouro(sede.getLogradouro());
		sedeHistorico.setNumero(sede.getNumero());
		sedeHistorico.setCep(sede.getCep());
		sedeHistorico.setComplemento(sede.getComplemento());

		sedeHistorico.setUserDatabaseCreate(sede.getUserDatabaseCreate());

		sedeHistorico.setUserDatabaseUpdate(dbUser2);

		sedeHistorico.setTimestampFirstCreated(sede.getTimestampFirstCreated());

		sedeHistorico.setTimestampLastUpdate(ZonedDateTime.now());

		sedeHistorico.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return sedeHistorico;
	}
}
