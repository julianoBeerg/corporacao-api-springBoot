package br.com.magna.corporacaoapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_PORTE")
@Entity
public class Porte extends AbstractEntity<Porte, Long>{

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
	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoPorte() {
		return tipoPorte;
	}

	public void setTipoPorte(String tipoPorte) {
		this.tipoPorte = tipoPorte;
	}
}
