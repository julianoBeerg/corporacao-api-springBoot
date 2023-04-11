package br.com.magna.corporacaoapi.entity;

import java.time.LocalDate;

import br.com.magna.corporacaoapi.record.DadosAtualizarInstituicao;
import br.com.magna.corporacaoapi.record.DadosCadastrarInstituicao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Table(name = "TB_INSTITUICAO")
@Entity
public class Instituicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_INSTITUICAO")
	private Long id;

	@Column(name = "VAR_TIPO_INSTITUICAO", nullable=false)
	private String tipoInstituicao;

	@Column(name = "VAR_FUNDADOR", nullable=false)
	private String fundador;

	@Column(name = "DATE_FUNDACAO", nullable=false)
	private LocalDate dataFundacao;

	@Column(name = "VAR_PRESIDENTE", nullable=false)
	private String presidente;

	@Column(name = "VAR_REPRESENTANTE", nullable=false)
	private String representante;

	@Column(name = "VAR_DIRETOR", nullable=false)
	private String diretor;

	public Instituicao(DadosCadastrarInstituicao dados) {
		this.tipoInstituicao = dados.tipoInstituicao();
		this.fundador = dados.fundador();
		this.dataFundacao = dados.dataFundacao();
		this.presidente = dados.presidente();
		this.representante = dados.representante();
		this.diretor = dados.diretor();
	}

	public void atualizarInformacoesInstituicao(@Valid DadosAtualizarInstituicao dados) {
		if (dados.presidente() != null) {
			this.presidente = dados.presidente();
		}
		if (dados.representante() != null) {
			this.representante = dados.representante();
		}
		if (dados.diretor() != null) {
			this.diretor = dados.diretor();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoInstituicao() {
		return tipoInstituicao;
	}

	public void setTipoInstituicao(String tipoInstituicao) {
		this.tipoInstituicao = tipoInstituicao;
	}

	public String getFundador() {
		return fundador;
	}

	public void setFundador(String fundador) {
		this.fundador = fundador;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
}
