package br.com.magna.corporacaoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.corporacaoapi.corporacao.DadosAtualizarCorporacao;
import br.com.magna.corporacaoapi.corporacao.DadosCadastrarCorporacao;
import br.com.magna.corporacaoapi.corporacao.DadosListarCorporacao;
import br.com.magna.corporacaoapi.instituicao.InstituicaoRepository;
import br.com.magna.corporacaoapi.sede.SedeRepository;
import br.com.magna.corporacaoapi.corporacao.Corporacao;
import br.com.magna.corporacaoapi.corporacao.CorporacaoRepository;
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
	public Page<DadosListarCorporacao> listarCorporacoes(
			@PageableDefault(size = 10, sort = { "razaoSocial" }) Pageable paginacao) {

		return corporacaoRepository.findAll(paginacao).map(DadosListarCorporacao::new);
	}

	@PutMapping
	@Transactional
	public void atualizarCorporacao(@RequestBody @Valid DadosAtualizarCorporacao dados) {
		var corporacao = corporacaoRepository.getReferenceById(dados.id());

		corporacao.atualizarInformacoes(dados);
	}

	@DeleteMapping("/deletar/{id}")
	@Transactional
	public void excluirCorporacao(@PathVariable Long id) {
		sedeRepository.deleteById(id);
		instituicaoRepository.deleteById(id);
		corporacaoRepository.deleteById(id);
	}

	@DeleteMapping("/inativar/{id}")
	@Transactional
	public void inativarCorporacao(@PathVariable Long id) {
		var medico = corporacaoRepository.getReferenceById(id);
		medico.inativarCnpj();
	}
}
