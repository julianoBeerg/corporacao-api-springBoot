package br.com.magna.corporacaoapi.entity;

import br.com.magna.corporacaoapi.record.DadosAtualizarNaturezaJuridica;
import br.com.magna.corporacaoapi.record.DadosCadastrarNaturezaJuridica;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Table(name = "TB_NATUREZA_JURIDICA")
@Entity(name = "NaturezaJuridica")
public class NaturezaJuridica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_NATUREZA_JURIDICA")
	private Long id;

	@Column(name = "INT_CODIGO_NATUREZA_JURIDICA")
	private Integer codigoNaturezaJuridica;

	@Column(name = "VAR_DESCRICAO_NATUREZA_JURIDICA")
	private String descricaoNaturezaJuridica;

	public NaturezaJuridica(DadosCadastrarNaturezaJuridica dados) {
		this.codigoNaturezaJuridica = dados.codigoNaturezaJuridica();
		this.descricaoNaturezaJuridica = dados.descricaoNaturezaJuridica();
	}

	public void atualizarInformacoesNaturezaJuridica(@Valid DadosAtualizarNaturezaJuridica dados) {
		if (dados.codigoNaturezaJuridica() != null) {
			this.codigoNaturezaJuridica = dados.codigoNaturezaJuridica();
		}
		if (dados.descricaoNaturezaJuridica() != null) {
			this.descricaoNaturezaJuridica = dados.descricaoNaturezaJuridica();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigoNaturezaJuridica() {
		return codigoNaturezaJuridica;
	}

	public void setCodigoNaturezaJuridica(Integer codigoNaturezaJuridica) {
		this.codigoNaturezaJuridica = codigoNaturezaJuridica;
	}

	public String getDescricaoNaturezaJuridica() {
		return descricaoNaturezaJuridica;
	}

	public void setDescricaoNaturezaJuridica(String descricaoNaturezaJuridica) {
		this.descricaoNaturezaJuridica = descricaoNaturezaJuridica;
	}
	
}
