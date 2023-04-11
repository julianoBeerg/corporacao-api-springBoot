package br.com.magna.corporacaoapi.entity;

import br.com.magna.corporacaoapi.record.DadosAtualizarCorporacao;
import br.com.magna.corporacaoapi.record.DadosCadastrarCorporacao;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Table(name = "TB_CORPORACAO")
@Entity
public class Corporacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_CORPORACAO")
	private Long id;

	@Column(name = "VAR_CNPJ", length = 18, nullable = false)
	private String cnpj;

	@Column(name = "VAR_RAZAO_SOCIAL", nullable = false)
	private String razaoSocial;

	@Column(name = "VAR_NOME_FANTASIA", nullable = false)
	private String nomeFantasia;

	@Column(name = "BOOL_TIPO_PUBLICO", nullable = false)
	private Boolean tipoPublico;

	@Column(name = "VAR_MULTINACIONAL", nullable = false)
	private Boolean multinacional;

	@Column(name = "BOOL_CNPJ_ATIVO", nullable = false)
	private Boolean cnpjAtivo;

	@Column(name = "DECIMAL_FATURAMENTO", nullable = false)
	private Double faturamento;

	@Column(name = "INT_NUMERO_FUNCIONARIOS", nullable = false)
	private Integer numFuncionarios;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_INSTITUICAO_ID")
	private Instituicao instituicao;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_PORTE_ID")
	private Porte porte;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ATIVIDADE_COMERCIAL_ID")
	private AtividadeComercial atividadeComercial;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_NATUREZA_JURIDICA_ID")
	private NaturezaJuridica naturezaJuridica;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_SEDE_ID")
	private Sede sede;

	public Corporacao(DadosCadastrarCorporacao dados) {
		this.cnpj = dados.cnpj();
		this.razaoSocial = dados.razaoSocial();
		this.nomeFantasia = dados.nomeFantasia();
		this.tipoPublico = dados.tipoPublico();
		this.multinacional = dados.multinacional();
		this.cnpjAtivo = true;
		this.faturamento = dados.faturamento();
		this.numFuncionarios = dados.numFuncionarios();
		this.instituicao = new Instituicao(dados.dadosCadastrarInstituicao());
		this.porte = new Porte(dados.dadosCadastrarPorte());
		this.atividadeComercial = new AtividadeComercial(dados.dadosCadastrarAtividadeComercial());
		this.naturezaJuridica = new NaturezaJuridica(dados.dadosCadastrarNaturezaJuridica());
		this.sede = new Sede(dados.dadosCadastrarSede());
	}

	public void atualizarInformacoes(@Valid DadosAtualizarCorporacao dados) {
		if (dados.nomeFantasia() != null) {
			this.nomeFantasia = dados.nomeFantasia();
		}
		if (dados.tipoPublico() != null) {
			this.tipoPublico = dados.tipoPublico();
		}
		if (dados.multinacional() != null) {
			this.multinacional = dados.multinacional();
		}
		if (dados.dadosAtualizarInstituicao() != null) {
			this.instituicao.atualizarInformacoesInstituicao(dados.dadosAtualizarInstituicao());
		}
		if (dados.dadosAtualizarPorte() != null) {
			this.porte.atualizarInformacoesPorte(dados.dadosAtualizarPorte());
		}
		if (dados.dadosAtualizarAtividadeComercial() != null) {
			this.atividadeComercial.atualizarInformacoesAtividadeComercial(dados.dadosAtualizarAtividadeComercial());
		}
		if (dados.dadosAtualizarNaturezaJuridica() != null) {
			this.naturezaJuridica.atualizarInformacoesNaturezaJuridica(dados.dadosAtualizarNaturezaJuridica());
		}
		if (dados.dadosAtualizarSede() != null) {
			this.sede.atualizarInformacoesSede(dados.dadosAtualizarSede());
		}
	}

	public void inativarCnpj() {
		this.cnpjAtivo = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Boolean getTipoPublico() {
		return tipoPublico;
	}

	public void setTipoPublico(Boolean tipoPublico) {
		this.tipoPublico = tipoPublico;
	}

	public Boolean getMultinacional() {
		return multinacional;
	}

	public void setMultinacional(Boolean multinacional) {
		this.multinacional = multinacional;
	}

	public Boolean getCnpjAtivo() {
		return cnpjAtivo;
	}

	public void setCnpjAtivo(Boolean cnpjAtivo) {
		this.cnpjAtivo = cnpjAtivo;
	}

	public Double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(Double faturamento) {
		this.faturamento = faturamento;
	}

	public Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Porte getPorte() {
		return porte;
	}

	public void setPorte(Porte porte) {
		this.porte = porte;
	}

	public AtividadeComercial getAtividadeComercial() {
		return atividadeComercial;
	}

	public void setAtividadeComercial(AtividadeComercial atividadeComercial) {
		this.atividadeComercial = atividadeComercial;
	}

	public NaturezaJuridica getNaturezaJuridica() {
		return naturezaJuridica;
	}

	public void setNaturezaJuridica(NaturezaJuridica naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

}
