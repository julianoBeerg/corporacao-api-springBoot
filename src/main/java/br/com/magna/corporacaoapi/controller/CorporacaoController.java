package br.com.magna.corporacaoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.corporacaoapi.model.Corporacao;
import br.com.magna.corporacaoapi.record.DadosAtualizarCorporacao;
import br.com.magna.corporacaoapi.record.DadosCadastrarCorporacao;
import br.com.magna.corporacaoapi.record.DadosListarCorporacao;
import br.com.magna.corporacaoapi.repository.CorporacaoRepository;
import br.com.magna.corporacaoapi.repository.InstituicaoRepository;
import br.com.magna.corporacaoapi.repository.SedeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("corporacoes")
public class CorporacaoController {

	@Autowired
	private CorporacaoRepository corporacaoRepository;
	
	@Autowired
	private InstituicaoRepository instituicaoRepository;
	
	@Autowired
	private SedeRepository sedeRepository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarCorporacao dadosCadastroCorporacao) {
		corporacaoRepository.save(new Corporacao(dadosCadastroCorporacao));	
	}

	@GetMapping
	public ResponseEntity<Page<DadosListarCorporacao>> listarCorporacoes(
			@PageableDefault(size = 10, sort = { "razaoSocial" }) Pageable paginacao) {
		 
		var page = corporacaoRepository.findAll(paginacao).map(DadosListarCorporacao::new);
		
		return ResponseEntity.ok(page);
	}

	@PutMapping
	@Transactional
	public void atualizarCorporacao(@RequestBody @Valid DadosAtualizarCorporacao dados) {
		var corporacao = corporacaoRepository.getReferenceById(dados.id());

		corporacao.atualizarInformacoes(dados);	
	}

	@DeleteMapping("/deletar/{id}")
	@Transactional
	public ResponseEntity<Long> excluirCorporacao(@PathVariable Long id) {
		sedeRepository.deleteById(id);
		instituicaoRepository.deleteById(id);
		corporacaoRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/inativar/{id}")
	@Transactional
	public ResponseEntity<Long> inativarCorporacao(@PathVariable Long id) {
		var corporacao = corporacaoRepository.getReferenceById(id);
		corporacao.inativarCnpj();
		
		return ResponseEntity.noContent().build();
	}
}
