package br.com.magna.corporacaoapi.record.atualizarcorporacao;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarInstituicao(

		@NotNull Long id,

		 String presidente,

		 String representante,

		 String diretor) {

}
