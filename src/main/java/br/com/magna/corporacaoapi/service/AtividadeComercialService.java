package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.AtividadeComercial;
import br.com.magna.corporacaoapi.entity.entityHistoric.AtividadeComercialHistoric;
import br.com.magna.corporacaoapi.record.DadosAtualizarAtividadeComercial;
import br.com.magna.corporacaoapi.record.DadosCadastrarAtividadeComercial;
import br.com.magna.corporacaoapi.repository.AtividadeComercialRepository;
import jakarta.validation.Valid;

@Service
public class AtividadeComercialService {

	@Autowired
	private AtividadeComercialRepository atividadeComercialRepository;

	public AtividadeComercial cadastrarAtividadeComercial(DadosCadastrarAtividadeComercial dados) {
		AtividadeComercial atividadeComercial = new AtividadeComercial();
		atividadeComercial.setCodigoAtividadeComercial(dados.codigoAtividadeComercial());
		atividadeComercial.setDescricaoAtividadeComercial(dados.descricaoAtividadeComercial());

		atividadeComercial.setUserDatabase("admin");

		atividadeComercial.setTimeStampFirstCreated(ZonedDateTime.now());

		atividadeComercial.setTimeStampLastUpdate(ZonedDateTime.now());

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
		
		atividadeComercial.setUserDatabase("admin");

		atividadeComercial.setTimeStampFirstCreated(atividadeComercial.getTimeStampFirstCreated());

		atividadeComercial.setTimeStampLastUpdate(ZonedDateTime.now());

		atividadeComercialRepository.save(atividadeComercial);

		return atividadeComercial;
	}

	public AtividadeComercialHistoric cadastrarAtividadeComercialHistorico(AtividadeComercial dados) {
		AtividadeComercialHistoric atividadeComercial = new AtividadeComercialHistoric();
		atividadeComercial.setCodigoAtividadeComercial(dados.getCodigoAtividadeComercial());
		atividadeComercial.setDescricaoAtividadeComercial(dados.getDescricaoAtividadeComercial());
		
		atividadeComercial.setUserDatabase("admin");

		atividadeComercial.setTimeStampFirstCreated(ZonedDateTime.now());

		atividadeComercial.setTimeStampLastUpdate(ZonedDateTime.now());

		return atividadeComercial;
	}
}
