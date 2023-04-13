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
import org.springframework.web.util.UriComponentsBuilder;

import br.com.magna.corporacaoapi.entity.Corporacao;
import br.com.magna.corporacaoapi.record.DadosAtualizarCorporacao;
import br.com.magna.corporacaoapi.record.DadosCadastrarCorporacao;
import br.com.magna.corporacaoapi.record.DadosListarCorporacao;
import br.com.magna.corporacaoapi.service.CorporacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("corporacoes")
public class CorporacaoController {

	@Autowired
	CorporacaoService corporacaoService;
	
//	@Autowired
//	CorporacaoRepository corporacaoRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<DadosListarCorporacao> cadastrarCorporacao(@RequestBody @Valid DadosCadastrarCorporacao dados,
			UriComponentsBuilder uriBuilder) {
		Corporacao corporacao = corporacaoService.cadastrarCorporacao(dados);
		var uri = uriBuilder.path("/corporacao/{id}").buildAndExpand(corporacao.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosListarCorporacao(corporacao));
	}

	@GetMapping("/listar")
	public ResponseEntity<Page<DadosListarCorporacao>> listarCorporacoes(
			@PageableDefault(size = 10, sort = { "razaoSocial" }) Pageable paginacao) {
		return ResponseEntity.ok(corporacaoService.listarCorporacoes(paginacao));
	}

	@GetMapping("/listar/ativo")
	public ResponseEntity<Page<DadosListarCorporacao>> listarCnpjAtivo(
			@PageableDefault(size = 10, sort = { "razaoSocial" }) Pageable paginacao) {

		return ResponseEntity.ok(corporacaoService.listarCnpjAtivo(paginacao));
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<DadosListarCorporacao> listarPorId(@PathVariable Long id) {

		return ResponseEntity.ok(new DadosListarCorporacao(corporacaoService.listarPorId(id)));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<DadosListarCorporacao> atualizarCorporacao(
			@RequestBody @Valid DadosAtualizarCorporacao dados) {

		return ResponseEntity.ok(new DadosListarCorporacao(corporacaoService.atualizarCorporacao(dados)));
	}

	@PutMapping("/ativar/{id}")
	@Transactional
	public ResponseEntity<DadosListarCorporacao> ativarCorporacao(@PathVariable Long id) {
		corporacaoService.ativarCnpj(id);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/inativar/{id}")
	@Transactional
	public ResponseEntity<Long> inativarCorporacao(@PathVariable Long id) {
		corporacaoService.inativarCnpj(id);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/deletar/{id}")
	@Transactional
	public ResponseEntity<Long> excluirCorporacao(@PathVariable Long id) {
		corporacaoService.excluirCorporacao(id);

		return ResponseEntity.noContent().build();
	}

}
