package br.com.magna.corporacaoapi.entity.entityHistoric;

import br.com.magna.corporacaoapi.entity.AbstractEntity;
import br.com.magna.corporacaoapi.entity.Corporacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_NATUREZA_JURIDICA_HISTORICO")
@Entity
public class NaturezaJuridicaHistorico extends AbstractEntity<Corporacao, Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "PK_ID_NATUREZA_JURIDICA_HIST")
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

	public void setCodigoNaturezaJuridica(Integer codigoNaturezaJuridica) {
		this.codigoNaturezaJuridica = codigoNaturezaJuridica;
	}

	public void setDescricaoNaturezaJuridica(String descricaoNaturezaJuridica) {
		this.descricaoNaturezaJuridica = descricaoNaturezaJuridica;
	}

}
