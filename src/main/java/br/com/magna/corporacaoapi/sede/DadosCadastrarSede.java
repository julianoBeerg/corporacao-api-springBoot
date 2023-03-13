package br.com.magna.corporacaoapi.sede;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastrarSede(

		@NotBlank String pais,

		@NotBlank String uf,

		@NotBlank String cidade,

		@NotBlank String logradouro,

		@NotNull @Positive Integer numero,

		@NotNull @Positive Integer cep,

		String complemento

) {

}
