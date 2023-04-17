package br.com.magna.corporacaoapi.entity.entityHistoric;

import br.com.magna.corporacaoapi.entity.AbstractEntity;
import br.com.magna.corporacaoapi.entity.Corporacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_ATIVIDADE_COMERCIAL_HIST")
@Entity
public class AtividadeComercialHistorico extends AbstractEntity<Corporacao, Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_ATIVIDADE_COMERCIAL_HIST")
	private Long id;

	@Column(name = "INT_CODIGO_ATIVIDADE_COMERCIAL", nullable = false)
	private Integer codigoAtividadeComercial;

	@Column(name = "VAR_DESCRICAO_ATIVIDADE_COMERCIAL", nullable = false)
	private String descricaoAtividadeComercial;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Long setId(Long id) {
		return this.id;
	}

	public Integer getCodigoAtividadeComercial() {
		return codigoAtividadeComercial;
	}

	public void setCodigoAtividadeComercial(Integer codigoAtividadeComercial) {
		this.codigoAtividadeComercial = codigoAtividadeComercial;
	}

	public String getDescricaoAtividadeComercial() {
		return descricaoAtividadeComercial;
	}

	public void setDescricaoAtividadeComercial(String descricaoAtividadeComercial) {
		this.descricaoAtividadeComercial = descricaoAtividadeComercial;
	}
}
