package br.com.magna.corporacaoapi.entity;

import br.com.magna.corporacaoapi.record.DadosAtualizarSede;
import br.com.magna.corporacaoapi.record.DadosCadastrarSede;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Table(name = "TB_SEDE")
@Entity(name = "Sede")
public class Sede {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_SEDE")
	private Long id;

	@Column(name = "VAR_PAIS", nullable=false)
	private String pais;

	@Column(name = "VAR_UF", nullable=false)
	private String uf;

	@Column(name = "VAR_CIDADE", nullable=false)
	private String cidade;
	
	@Column(name = "VAR_LOGRADOURO", nullable=false)
	private String logradouro;

	@Column(name = "INT_NUMERO", nullable=false)
	private Integer numero;

	@Column(name = "INT_CEP", nullable=false)
	private Integer cep;

	@Column(name = "VAR_COMPLEMENTO", nullable=false)
	private String complemento;

	public Sede(DadosCadastrarSede dados) {
		this.pais = dados.pais();
		this.uf = dados.uf();
		this.cidade = dados.cidade();
		this.logradouro = dados.logradouro();
		this.numero = dados.numero();
		this.cep = dados.cep();
		this.complemento = dados.complemento();
	}

	public void atualizarInformacoesSede(@Valid DadosAtualizarSede dados) {
		if (dados.pais() != null) {
			this.pais = dados.pais();
		}
		if (dados.uf() != null) {
			this.uf = dados.uf();
		}
		if (dados.cidade() != null) {
			this.cidade = dados.cidade();
		}
		if (dados.logradouro() != null) {
			this.logradouro = dados.logradouro();
		}
		if (dados.numero() != null) {
			this.numero = dados.numero();
		}
		if (dados.cep() != null) {
			this.cep = dados.cep();
		}
		if (dados.complemento() != null) {
			this.complemento = dados.complemento();
		}
	}

	public Long getId() {
		return id;
	}

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
