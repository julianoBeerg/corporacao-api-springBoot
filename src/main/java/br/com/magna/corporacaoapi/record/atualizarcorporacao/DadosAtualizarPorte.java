package br.com.magna.corporacaoapi.record.atualizarcorporacao;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPorte(
		
		@NotNull Long id,

		String tipoPorte
		) {
	
	

}
