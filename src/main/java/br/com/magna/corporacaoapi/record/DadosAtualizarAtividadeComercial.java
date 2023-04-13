package br.com.magna.corporacaoapi.record;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAtividadeComercial(
		@NotNull Long id,
		
		Integer codigoAtividadeComercial,
		
		String descricaoAtividadeComercial
		) {
	
	

}
