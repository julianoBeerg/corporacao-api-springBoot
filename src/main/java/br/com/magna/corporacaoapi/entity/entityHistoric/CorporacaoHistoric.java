package br.com.magna.corporacaoapi.entity.entityHistoric;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import br.com.magna.corporacaoapi.entity.AbstractEntity;

@Table(name = "TB_CORPORACAO_HISTORIC")
@Entity
public class CorporacaoHistoric extends AbstractEntity<CorporacaoHistoric, Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_CORPORACAO_HISTORIC")
	private Long id;

	@Column(name = "ID_CORPORACAO")
	private Long idCorporacao;

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
	private Boolean cnpjAtivo = true;

	@Column(name = "DECIMAL_FATURAMENTO", nullable = false)
	private Double faturamento;

	@Column(name = "INT_NUMERO_FUNCIONARIOS", nullable = false)
	private Integer numFuncionarios;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "FK_INSTITUICAO_ID")
	private InstituicaoHistoric instituicao;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_PORTE_ID")
	private PorteHistoric porte;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ATIVIDADE_COMERCIAL_ID")
	private AtividadeComercialHistoric atividadeComercial;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_NATUREZA_JURIDICA_ID")
	private NaturezaJuridicaHistoric naturezaJuridica;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_SEDE_ID")
	private SedeHistoric sede;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Long setId(Long id) {
		return this.id;
	}

	public Long getIdCorporacao() {
		return idCorporacao;
	}

	public void setIdCorporacao(Long idCorporacao) {
		this.idCorporacao = idCorporacao;
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

	public InstituicaoHistoric getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoHistoric instituicao) {
		this.instituicao = instituicao;
	}

	public PorteHistoric getPorte() {
		return porte;
	}

	public void setPorte(PorteHistoric porte) {
		this.porte = porte;
	}

	public AtividadeComercialHistoric getAtividadeComercial() {
		return atividadeComercial;
	}

	public void setAtividadeComercial(AtividadeComercialHistoric atividadeComercial) {
		this.atividadeComercial = atividadeComercial;
	}

	public NaturezaJuridicaHistoric getNaturezaJuridica() {
		return naturezaJuridica;
	}

	public void setNaturezaJuridica(NaturezaJuridicaHistoric naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}

	public SedeHistoric getSede() {
		return sede;
	}

	public void setSede(SedeHistoric sede) {
		this.sede = sede;
	}

}
