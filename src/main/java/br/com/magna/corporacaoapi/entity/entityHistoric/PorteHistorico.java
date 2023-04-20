package br.com.magna.corporacaoapi.entity.entityHistoric;

import br.com.magna.corporacaoapi.entity.AbstractEntity;
import br.com.magna.corporacaoapi.entity.Corporacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_PORTE_HISTORICO")
@Entity
public class PorteHistorico extends AbstractEntity<Corporacao, Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_PORTE_HIST")
	private Long id;

	@Column(name = "VAR_TIPO_PORTE", nullable = false)
	private String tipoPorte;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setTipoPorte(String tipoPorte) {
		this.tipoPorte = tipoPorte;
	}
}
