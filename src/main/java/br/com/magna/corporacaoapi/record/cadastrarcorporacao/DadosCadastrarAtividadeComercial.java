package br.com.magna.corporacaoapi.record.cadastrarcorporacao;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarAtividadeComercial(
		
		@NotBlank(message = "Código atividade comercial é obrigatório")
		Integer codigoAtividadeComercial,
		
		@NotBlank(message = "Descrição comercial é obrigatório") 
		String descricaoAtividadeComercial
		) {

}
