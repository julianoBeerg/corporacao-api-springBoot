package br.com.magna.corporacaoapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_NATUREZA_JURIDICA")
@Entity
public class NaturezaJuridica extends AbstractEntity<NaturezaJuridica, Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "PK_ID_NATUREZA_JURIDICA")
	private Long id;

	@Column(name = "INT_CODIGO_NATUREZA_JURIDICA", nullable = false)
	private Integer codigoNaturezaJuridica;

	@Column(name = "VAR_DESCRICAO_NATUREZA_JURIDICA", nullable = false)
	private String descricaoNaturezaJuridica;

	@Override
	public Long getId() {
		return id;
	}

	@Override
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
