package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.Sede;
import br.com.magna.corporacaoapi.entity.entityHistoric.SedeHistoric;
import br.com.magna.corporacaoapi.record.DadosAtualizarSede;
import br.com.magna.corporacaoapi.record.DadosCadastrarSede;
import br.com.magna.corporacaoapi.repository.SedeRepository;

@Service
public class SedeService {

	@Autowired
	private SedeRepository sedeRepository;

	public Sede cadastrarSede(DadosCadastrarSede dados) {
		Sede sede = new Sede();
		sede.setPais(dados.pais());
		sede.setUf(dados.uf());
		sede.setCidade(dados.cidade());
		sede.setLogradouro(dados.logradouro());
		sede.setNumero(dados.numero());
		sede.setCep(dados.cep());
		sede.setComplemento(dados.complemento());

		sede.setUserDatabase("admin");

		sede.setTimeStampFirstCreated(ZonedDateTime.now());

		sede.setTimeStampLastUpdate(ZonedDateTime.now());

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

		sede.setUserDatabase("admin");

		sede.setTimeStampFirstCreated(sede.getTimeStampFirstCreated());

		sede.setTimeStampLastUpdate(ZonedDateTime.now());
		
		sedeRepository.save(sede);

		return sede;
	}

	public SedeHistoric cadastrarSedeHistorioco(Sede dados) {
		SedeHistoric sede = new SedeHistoric();
		sede.setPais(dados.getPais());
		sede.setUf(dados.getUf());
		sede.setCidade(dados.getCidade());
		sede.setLogradouro(dados.getLogradouro());
		sede.setNumero(dados.getNumero());
		sede.setCep(dados.getCep());
		sede.setComplemento(dados.getComplemento());
		
		sede.setUserDatabase("admin");

		sede.setTimeStampFirstCreated(ZonedDateTime.now());

		sede.setTimeStampLastUpdate(ZonedDateTime.now());

		return sede;
	}
}
