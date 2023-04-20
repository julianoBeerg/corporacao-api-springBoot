package br.com.magna.corporacaoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.corporacaoapi.entity.Corporacao;
import br.com.magna.corporacaoapi.service.CorporacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("corporacoes")
public class CorporacaoController {

	@Autowired
	CorporacaoService corporacaoService;

	@PostMapping
	@Transactional
	public ResponseEntity<Corporacao> cadastrar(@RequestBody @Valid Corporacao dados) {
		corporacaoService.cadastrarCorporacao(dados);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	@Transactional

	public ResponseEntity<Corporacao> atualizarCorporacao(@RequestBody @Valid Corporacao dados) {
		corporacaoService.atualizarCorporacao(dados);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/listar")
	public ResponseEntity<Page<Corporacao>> listarCorporacoes(
			@PageableDefault(size = 10, sort = { "razaoSocial" }) Pageable paginacao) {
		return ResponseEntity.ok(corporacaoService.listarCorporacoes(paginacao));
	}

	@GetMapping("/listar/ativo")
	public ResponseEntity<Page<Corporacao>> listarCnpjAtivo(
			@PageableDefault(size = 10, sort = { "razaoSocial" }) Pageable paginacao) {

		return ResponseEntity.ok(corporacaoService.listarCnpjAtivo(paginacao));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Corporacao> procurarPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(corporacaoService.listarPorID(id));
	}

	@PutMapping("/ativar/{id}")
	@Transactional
	public ResponseEntity<Corporacao> ativarCorporacao(@PathVariable Long id) {
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
