package br.com.magna.corporacaoapi.record.atualizarcorporacao;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCorporacao(

		@NotNull Long id,

		String nomeFantasia,

		Boolean tipoPublico,

		Boolean multinacional,

		Double faturamento,

		Integer numFuncionarios,

		DadosAtualizarSede dadosAtualizarSede,

		DadosAtualizarPorte dadosAtualizarPorte,

		DadosAtualizarAtividadeComercial dadosAtualizarAtividadeComercial,

		DadosAtualizarNaturezaJuridica dadosAtualizarNaturezaJuridica,

		DadosAtualizarInstituicao dadosAtualizarInstituicao) {

}
