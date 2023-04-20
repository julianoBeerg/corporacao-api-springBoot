package br.com.magna.corporacaoapi.entity.entityHistoric;

import java.time.LocalDate;

import br.com.magna.corporacaoapi.entity.AbstractEntity;
import br.com.magna.corporacaoapi.entity.Corporacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "TB_INSTITUICAO_HISTORICO")
@Entity
public class InstituicaoHistorico extends AbstractEntity<Corporacao, Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_INSTITUICAO_HIST")
	private Long id;

	@Column(name = "VAR_TIPO_INSTITUICAO", nullable = false)
	private String tipoInstituicao;

	@Column(name = "VAR_FUNDADOR", nullable = false)
	private String fundador;

	@Column(name = "DATE_FUNDACAO", nullable = false)
	private LocalDate dataFundacao;

	@Column(name = "VAR_PRESIDENTE", nullable = false)
	private String presidente;

	@Column(name = "VAR_REPRESENTANTE", nullable = false)
	private String representante;

	@Column(name = "VAR_DIRETOR", nullable = false)
	private String diretor;

	@OneToOne(mappedBy = "instituicao", fetch = FetchType.EAGER)
	private CorporacaoHistorico corporacao;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setTipoInstituicao(String tipoInstituicao) {
		this.tipoInstituicao = tipoInstituicao;
	}

	public void setFundador(String fundador) {
		this.fundador = fundador;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

}
