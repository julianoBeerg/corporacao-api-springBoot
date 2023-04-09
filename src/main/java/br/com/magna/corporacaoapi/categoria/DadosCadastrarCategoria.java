package br.com.magna.corporacaoapi.categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarCategoria(
		
		@NotBlank Integer codigoNaturezaJuridica,
		@NotBlank String descricaoNaturezaJuridica,
		@NotBlank Integer codigoAtividadeComercial,
		@NotBlank String descricaoAtividadeComercial
		
		) {

}
