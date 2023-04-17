package br.com.magna.corporacaoapi.record.atualizarcorporacao;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAtividadeComercial(
		@NotNull Long id,
		
		Integer codigoAtividadeComercial,
		
		String descricaoAtividadeComercial
		) {
	
	

}
