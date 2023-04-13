package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.Porte;
import br.com.magna.corporacaoapi.entity.entityHistoric.PorteHistoric;
import br.com.magna.corporacaoapi.record.DadosAtualizarPorte;
import br.com.magna.corporacaoapi.record.DadosCadastrarPorte;
import br.com.magna.corporacaoapi.repository.PorteRepository;

@Service
public class PorteService {

	@Autowired
	private PorteRepository porteRepository;

	public Porte cadastrarPorte(DadosCadastrarPorte dados) {
		Porte porte = new Porte();
		porte.setTipoPorte(dados.tipoPorte());

		porte.setUserDatabase("admin");

		porte.setTimeStampFirstCreated(ZonedDateTime.now());

		porte.setTimeStampLastUpdate(ZonedDateTime.now());

		return porte;
	}

	public Porte atualizarPorte(DadosAtualizarPorte dados) {

		var porte = porteRepository.getReferenceById(dados.id());

		if (dados.tipoPorte() != null) {
			porte.setTipoPorte(dados.tipoPorte());
		}
		porte.setUserDatabase("admin");

		porte.setTimeStampFirstCreated(porte.getTimeStampFirstCreated());

		porte.setTimeStampLastUpdate(ZonedDateTime.now());

		return porte;
	}

	public PorteHistoric cadastrarPorteHistorico(Porte dados) {
		PorteHistoric porte = new PorteHistoric();
		porte.setTipoPorte(dados.getTipoPorte());
		
		porte.setUserDatabase("admin");

		porte.setTimeStampFirstCreated(ZonedDateTime.now());

		porte.setTimeStampLastUpdate(ZonedDateTime.now());

		return porte;
	}
}
