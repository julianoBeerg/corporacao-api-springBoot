package br.com.magna.corporacaoapi.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastrarSede(

		@NotBlank (message = "País é obrigatório")
		String pais,

		@NotBlank (message = "UF é obrigatório")
		String uf,

		@NotBlank (message = "Cidade é obrigatório")
		String cidade,

		@NotBlank (message = "Logradouro é obrigatório")
		String logradouro,

		@NotNull @Positive (message = "Número é obrigatório e precisa ser positivo")
		Integer numero,

		@NotNull @Positive (message = "CEP é obrigatório e precisa ser positivo")
		Integer cep,

		String complemento

) {

}
