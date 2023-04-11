package br.com.magna.corporacaoapi.record;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarNaturezaJuridica(
		
		@NotBlank (message = "Código da Natureza Juridica é obrigatório")
		Integer codigoNaturezaJuridica,
		
		@NotBlank (message = "Descrição da Natureza Juridica é obrigatório")
		String descricaoNaturezaJuridica	
		
		) {
}
