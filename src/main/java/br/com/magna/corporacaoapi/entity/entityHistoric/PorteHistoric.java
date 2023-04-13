package br.com.magna.corporacaoapi.entity.entityHistoric;

import br.com.magna.corporacaoapi.entity.AbstractEntity;
import br.com.magna.corporacaoapi.entity.Corporacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_PORTE_HISTORIC")
@Entity
public class PorteHistoric extends AbstractEntity<Corporacao, Long>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_PORTE")
	private Long id;

	@Column(name = "VAR_TIPO_PORTE", nullable = false)
	private String tipoPorte;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Long setId(Long id) {
		return this.id;
	}

	public String getTipoPorte() {
		return tipoPorte;
	}

	public void setTipoPorte(String tipoPorte) {
		this.tipoPorte = tipoPorte;
	}
}
