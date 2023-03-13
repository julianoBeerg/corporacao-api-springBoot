package br.com.magna.corporacaoapi.sede;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarSede(

		@NotNull Long id,

		String pais,

		String uf,

		String cidade,

		String logradouro,

		Integer numero,

		Integer cep,

		String complemento) {

}
