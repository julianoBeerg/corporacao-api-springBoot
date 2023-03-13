package br.com.magna.corporacaoapi.corporacao;

import br.com.magna.corporacaoapi.instituicao.DadosAtualizarInstituicao;
import br.com.magna.corporacaoapi.sede.DadosAtualizarSede;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCorporacao(

		@NotNull Long id,

		String nomeFantasia,

		Boolean tipoPublico,

		Boolean multinacional,

		Double faturamento,

		Integer numFuncionarios,

		DadosAtualizarSede dadosAtualizarSede,

		DadosAtualizarInstituicao dadosAtualizarInstituicao) {

}
