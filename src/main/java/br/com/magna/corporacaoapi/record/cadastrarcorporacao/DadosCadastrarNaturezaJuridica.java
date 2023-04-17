package br.com.magna.corporacaoapi.record.cadastrarcorporacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarNaturezaJuridica(
		
		@NotNull (message = "Código da Natureza Juridica é obrigatório")
		Integer codigoNaturezaJuridica,
		
		@NotBlank (message = "Descrição da Natureza Juridica é obrigatório")
		String descricaoNaturezaJuridica	
		
		) {
}
