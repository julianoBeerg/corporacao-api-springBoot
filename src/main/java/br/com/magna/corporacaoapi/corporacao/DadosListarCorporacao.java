package br.com.magna.corporacaoapi.corporacao;

import br.com.magna.corporacaoapi.instituicao.Instituicao;
import br.com.magna.corporacaoapi.sede.Sede;

public record DadosListarCorporacao(

		Long id, String cnpj, String razaoSocial, String nomeFantasia, Boolean tipoPublico, Boolean multinacional,
		Boolean cnpjAtivo, Double faturamento, Integer numFuncionarios, Instituicao instituicao, Sede sede) {

	public DadosListarCorporacao(Corporacao corporacao) {
		this(corporacao.getId(), corporacao.getCnpj(), corporacao.getRazaoSocial(), corporacao.getNomeFantasia(),
				corporacao.getTipoPublico(), corporacao.getMultinacional(), corporacao.getCnpjAtivo(),
				corporacao.getFaturamento(), corporacao.getNumFuncionarios(), corporacao.getInstituicao(),
				corporacao.getSede());
	}
}
