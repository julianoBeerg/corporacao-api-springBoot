package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.Sede;
import br.com.magna.corporacaoapi.entity.entityHistoric.SedeHistorico;
import br.com.magna.corporacaoapi.record.atualizarcorporacao.DadosAtualizarSede;
import br.com.magna.corporacaoapi.record.cadastrarcorporacao.DadosCadastrarSede;
import br.com.magna.corporacaoapi.repository.SedeRepository;

@Service
public class SedeService {

	@Autowired
	private SedeRepository sedeRepository;

	private String dbUser = "Admin";

	private String dbUser2 = "Admin2";

	public Sede cadastrarSede(DadosCadastrarSede dados) {
		Sede sede = new Sede();
		sede.setPais(dados.pais());
		sede.setUf(dados.uf());
		sede.setCidade(dados.cidade());
		sede.setLogradouro(dados.logradouro());
		sede.setNumero(dados.numero());
		sede.setCep(dados.cep());
		sede.setComplemento(dados.complemento());

		sede.setUserDatabaseCreate(dbUser);

		sede.setUserDatabaseUpdate(dbUser);

		sede.setTimestampFirstCreated(ZonedDateTime.now());

		sede.setTimestampLastUpdate(ZonedDateTime.now());

		sede.setTimestampTimeZone(ZonedDateTime.now().getZone());

		return sede;
	}

	public Sede atualizarSede(DadosAtualizarSede dados) {

		var sede = sedeRepository.getReferenceById(dados.id());

		if (dados.pais() != null) {
			sede.setPais(dados.pais());
		}
		if (dados.uf() != null) {
			sede.setUf(dados.uf());
		}
		if (dados.cidade() != null) {
			sede.setCidade(dados.cidade());
		}
		if (dados.logradouro() != null) {
			sede.setLogradouro(dados.logradouro());
		}
		if (dados.numero() != null) {
			sede.setNumero(dados.numero());
		}
		if (dados.cep() != null) {
			sede.setCep(dados.cep());
		}
		if (dados.complemento() != null) {
			sede.setComplemento(dados.complemento());
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
