package br.com.magna.corporacaoapi.corporacao;

import br.com.magna.corporacaoapi.categoria.DadosCadastrarCategoria;
import br.com.magna.corporacaoapi.instituicao.DadosCadastrarInstituicao;
import br.com.magna.corporacaoapi.porte.DadosCadastrarPorte;
import br.com.magna.corporacaoapi.sede.DadosCadastrarSede;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarCorporacao(

		@NotBlank String cnpj,

		@NotBlank String razaoSocial,

		@NotBlank String nomeFantasia,

		@NotNull Boolean tipoPublico,

		@NotNull Boolean multinacional,

		@NotNull Double faturamento,

		@NotNull Integer numFuncionarios,

		@NotNull DadosCadastrarInstituicao dadosCadastrarInstituicao,
		
		@NotNull DadosCadastrarPorte dadosCadastrarPorte,
		
		@NotNull DadosCadastrarCategoria dadosCadastrarCategoria,

		@NotNull DadosCadastrarSede dadosCadastrarSede) {

}
