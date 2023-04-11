//package br.com.magna.corporacaoapi.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import br.com.magna.botanica.api.model.Raiz;
//import br.com.magna.botanica.api.record.DadosAtualizacaoPlanta;
//import br.com.magna.corporacaoapi.entity.Porte;
//import br.com.magna.corporacaoapi.record.DadosAtualizarPorte;
//import br.com.magna.corporacaoapi.record.DadosCadastrarPorte;
//import br.com.magna.corporacaoapi.repository.PorteRepository;
//
//
//
//@Service
//public class PorteService {
//	
//	@Autowired
//	PorteRepository porteRepository;
//	
//	public Porte validacaoCadastrarDadosPorte(DadosCadastrarPorte dados) {
//		return porteRepository.validandoPorte(dados.id(), dados.tipoPorte());
//	}
//	
//	public Porte validacaoAtualizarDadosPorte(DadosAtualizarPorte dados) {
//		return raizRepository.validandoRaizComClasse(dados.raizId(),dados.classeId());
//	}
//}
