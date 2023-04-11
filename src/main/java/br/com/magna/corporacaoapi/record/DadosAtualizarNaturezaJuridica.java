package br.com.magna.corporacaoapi.record;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarNaturezaJuridica(
		
		@NotNull Long id,
		Integer codigoNaturezaJuridica,
		String descricaoNaturezaJuridica
		) {
}
