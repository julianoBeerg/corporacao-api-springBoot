package br.com.magna.corporacaoapi.instituicao;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarInstituicao(

		@NotBlank String tipoInstituicao,

		@NotBlank String fundador,

		@NotNull LocalDate dataFundacao,

		@NotBlank String presidente,

		@NotBlank String representante,

		@NotBlank String diretor

) {

}
