 package br.com.magna.corporacaoapi.record.cadastrarcorporacao;

import java.time.ZonedDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarCorporacao(

		@NotBlank(message = "{cnpj.obrigatorio}") 
		String cnpj,

		@NotBlank(message = "{razaoSocial.obrigatorio}") 
		String razaoSocial,

		@NotBlank String nomeFantasia,

		@NotNull Boolean tipoPublico,

		@NotNull Boolean multinacional,

		@NotNull Double faturamento,
		
		//@NotNull Boolean cnpjAtivo,

		@NotNull Integer numFuncionarios,

		@NotNull DadosCadastrarInstituicao dadosCadastrarInstituicao,
		
		@NotNull DadosCadastrarPorte dadosCadastrarPorte,
		
		@NotNull DadosCadastrarAtividadeComercial dadosCadastrarAtividadeComercial,
		
		@NotNull DadosCadastrarNaturezaJuridica dadosCadastrarNaturezaJuridica,

		@NotNull DadosCadastrarSede dadosCadastrarSede,
		
		 String userDatabase,
		
		ZonedDateTime timeStampFirstCreated
		
		) {
}
