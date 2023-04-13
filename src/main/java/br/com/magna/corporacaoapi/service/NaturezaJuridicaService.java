package br.com.magna.corporacaoapi.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.corporacaoapi.entity.NaturezaJuridica;
import br.com.magna.corporacaoapi.entity.entityHistoric.NaturezaJuridicaHistoric;
import br.com.magna.corporacaoapi.record.DadosAtualizarNaturezaJuridica;
import br.com.magna.corporacaoapi.record.DadosCadastrarNaturezaJuridica;
import br.com.magna.corporacaoapi.repository.NaturezaJuridicaRepository;
import jakarta.validation.Valid;

@Service
public class NaturezaJuridicaService {

	@Autowired
	private NaturezaJuridicaRepository naturezaJuridicaRepository;

	public NaturezaJuridica cadastrarNaturezaJuridica(DadosCadastrarNaturezaJuridica dados) {
		NaturezaJuridica naturezaJuridica = new NaturezaJuridica();
		naturezaJuridica.setCodigoNaturezaJuridica(dados.codigoNaturezaJuridica());
		naturezaJuridica.setDescricaoNaturezaJuridica(dados.descricaoNaturezaJuridica());

		naturezaJuridica.setUserDatabase("admin");

		naturezaJuridica.setTimeStampFirstCreated(ZonedDateTime.now());

		naturezaJuridica.setTimeStampLastUpdate(ZonedDateTime.now());

		return naturezaJuridica;
	}

	public NaturezaJuridica atualizarNaturezaJuridica(@Valid DadosAtualizarNaturezaJuridica dados) {

		NaturezaJuridica naturezaJuridica = new NaturezaJuridica();

		if (dados.codigoNaturezaJuridica() != null) {
			naturezaJuridica.setCodigoNaturezaJuridica(dados.codigoNaturezaJuridica());
		}
		if (dados.descricaoNaturezaJuridica() != null) {
			naturezaJuridica.setDescricaoNaturezaJuridica(dados.descricaoNaturezaJuridica());
		}
		
		naturezaJuridica.setUserDatabase("admin");

		naturezaJuridica.setTimeStampFirstCreated(ZonedDateTime.now());
 
		naturezaJuridica.setTimeStampLastUpdate(ZonedDateTime.now());

		naturezaJuridicaRepository.save(naturezaJuridica);

		return naturezaJuridica;
	}

	public NaturezaJuridicaHistoric cadastrarNaturezaJuridicaHistorico(NaturezaJuridica dados) {
		NaturezaJuridicaHistoric naturezaJuridica = new NaturezaJuridicaHistoric();
		naturezaJuridica.setCodigoNaturezaJuridica(dados.getCodigoNaturezaJuridica());
		naturezaJuridica.setDescricaoNaturezaJuridica(dados.getDescricaoNaturezaJuridica());
		
		naturezaJuridica.setUserDatabase("admin");

		naturezaJuridica.setTimeStampFirstCreated(ZonedDateTime.now());

		naturezaJuridica.setTimeStampLastUpdate(ZonedDateTime.now());

		return naturezaJuridica;
	}
}
