package br.com.magna.corporacaoapi.record.atualizarcorporacao;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarNaturezaJuridica(
		
		@NotNull Long id,
		
		 Integer codigoNaturezaJuridica,
		
		 String descricaoNaturezaJuridica
		) {
}
