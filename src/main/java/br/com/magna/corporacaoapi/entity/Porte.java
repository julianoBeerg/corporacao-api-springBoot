package br.com.magna.corporacaoapi.entity;


import br.com.magna.corporacaoapi.record.DadosAtualizarPorte;
import br.com.magna.corporacaoapi.record.DadosCadastrarPorte;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Table(name = "TB_PORTE")
@Entity(name = "Porte")
public class Porte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_PORTE")
	private Long id;
	
	@Column(name = "VAR_TIPO_PORTE")
	private String tipoPorte;
	
	public Porte(DadosCadastrarPorte dados) {
		this.tipoPorte = dados.tipoPorte();
	}

	public void atualizarInformacoesPorte(@Valid DadosAtualizarPorte dados) {
		if (dados.tipoPorte() != null) {
			this.tipoPorte = dados.tipoPorte();
		}	
	}
	
	public Long getId() {
		return id;
	}

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
