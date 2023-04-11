package br.com.magna.corporacaoapi.record;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarInstituicao(

		@NotBlank (message = "Tipo de instituição é obrigatório")
		String tipoInstituicao,

		@NotBlank (message = "Fundador é obrigatório")
		String fundador,

		@NotNull (message = "Data de fundação é obrigatório")
		LocalDate dataFundacao,

		@NotBlank (message = "Presidente é obrigatório")
		String presidente,

		@NotBlank (message = "Representante é obrigatório")
		String representante,

		@NotBlank (message = "Diretor é obrigatório")
		String diretor
) {

}
