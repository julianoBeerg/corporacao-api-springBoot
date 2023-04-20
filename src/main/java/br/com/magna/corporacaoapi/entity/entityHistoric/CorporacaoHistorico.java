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

@Table(name = "TB_CORPORACAO_HISTORICO")
@Entity
public class CorporacaoHistorico extends AbstractEntity<CorporacaoHistorico, Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_CORPORACAO_HIST")
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
	private InstituicaoHistorico instituicao;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_PORTE_ID")
	private PorteHistorico porte;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ATIVIDADE_COMERCIAL_ID")
	private AtividadeComercialHistorico atividadeComercial;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_NATUREZA_JURIDICA_ID")
	private NaturezaJuridicaHistorico naturezaJuridica;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_SEDE_ID")
	private SedeHistorico sede;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setIdCorporacao(Long idCorporacao) {
		this.idCorporacao = idCorporacao;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public void setTipoPublico(Boolean tipoPublico) {
		this.tipoPublico = tipoPublico;
	}

	public void setMultinacional(Boolean multinacional) {
		this.multinacional = multinacional;
	}

	public void setFaturamento(Double faturamento) {
		this.faturamento = faturamento;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	public void setInstituicao(InstituicaoHistorico instituicao) {
		this.instituicao = instituicao;
	}

	public void setPorte(PorteHistorico porte) {
		this.porte = porte;
	}

	public void setAtividadeComercial(AtividadeComercialHistorico atividadeComercial) {
		this.atividadeComercial = atividadeComercial;
	}

	public void setNaturezaJuridica(NaturezaJuridicaHistorico naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}

	public void setSede(SedeHistorico sede) {
		this.sede = sede;
	}

}
