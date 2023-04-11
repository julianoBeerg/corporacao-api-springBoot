package br.com.magna.corporacaoapi.record;

import br.com.magna.corporacaoapi.model.AtividadeComercial;
import br.com.magna.corporacaoapi.model.Corporacao;
import br.com.magna.corporacaoapi.model.Instituicao;
import br.com.magna.corporacaoapi.model.NaturezaJuridica;
import br.com.magna.corporacaoapi.model.Porte;
import br.com.magna.corporacaoapi.model.Sede;

public record DadosListarCorporacao(

		Long id, String cnpj, String razaoSocial, String nomeFantasia, Boolean tipoPublico, Boolean multinacional,
		Boolean cnpjAtivo, Double faturamento, Integer numFuncionarios, Instituicao instituicao, Porte porte, 
		AtividadeComercial atividadeComercial, NaturezaJuridica naturezaJuridica, Sede sede) {

	public DadosListarCorporacao(Corporacao corporacao) {
		this(corporacao.getId(), corporacao.getCnpj(), corporacao.getRazaoSocial(), corporacao.getNomeFantasia(),
				corporacao.getTipoPublico(), corporacao.getMultinacional(), corporacao.getCnpjAtivo(),
				corporacao.getFaturamento(), corporacao.getNumFuncionarios(), corporacao.getInstituicao(),
				corporacao.getPorte(), corporacao.getAtividadeComercial(), corporacao.getNaturezaJuridica(),
				corporacao.getSede());
	}
}
