package br.com.magna.corporacaoapi.categoria;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCategoria(
		@NotNull Long id,
		Integer codigoNaturezaJuridica,
		String descricaoNaturezaJuridica,
		Integer codigoAtividadeComercial,
		String descricaoAtividadeComercial
		) {
	
	

}
