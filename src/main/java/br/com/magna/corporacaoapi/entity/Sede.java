package br.com.magna.corporacaoapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_SEDE")
@Entity
public class Sede extends AbstractEntity<Sede, Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_SEDE")
	private Long id;

	@Column(name = "VAR_PAIS", nullable = false)
	private String pais;

	@Column(name = "VAR_UF", nullable = false)
	private String uf;

	@Column(name = "VAR_CIDADE", nullable = false)
	private String cidade;

	@Column(name = "VAR_LOGRADOURO", nullable = false)
	private String logradouro;

	@Column(name = "INT_NUMERO", nullable = false)
	private Integer numero;

	@Column(name = "INT_CEP", nullable = false)
	private Integer cep;

	@Column(name = "VAR_COMPLEMENTO", nullable = false)
	private String complemento;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
