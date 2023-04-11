package br.com.magna.corporacaoapi.entity;

import br.com.magna.corporacaoapi.record.DadosAtualizarAtividadeComercial;
import br.com.magna.corporacaoapi.record.DadosCadastrarAtividadeComercial;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Table(name = "TB_ATIVIDADE_COMERCIAL")
@Entity(name = "AtividadeComercial")
public class AtividadeComercial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_ATIVIDADE_COMERCIAL")
	private Long id;
	
	@Column(name = "INT_CODIGO_ATIVIDADE_COMERCIAL", nullable=false)
	private Integer codigoAtividadeComercial;

	@Column(name = "VAR_DESCRICAO_ATIVIDADE_COMERCIAL", nullable=false)
	private String descricaoAtividadeComercial;

	public AtividadeComercial(DadosCadastrarAtividadeComercial dados) {
		this.codigoAtividadeComercial = dados.codigoAtividadeComercial();
		this.descricaoAtividadeComercial = dados.descricaoAtividadeComercial();
	}

	public void atualizarInformacoesAtividadeComercial(@Valid DadosAtualizarAtividadeComercial dados) {
		if (dados.codigoAtividadeComercial() != null) {
			this.codigoAtividadeComercial = dados.codigoAtividadeComercial();
		}
		if (dados.descricaoAtividadeComercial() != null) {
			this.descricaoAtividadeComercial = dados.descricaoAtividadeComercial();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigoAtividadeComercial() {
		return codigoAtividadeComercial;
	}

	public void setCodigoAtividadeComercial(Integer codigoAtividadeComercial) {
		this.codigoAtividadeComercial = codigoAtividadeComercial;
	}

	public String getDescricaoAtividadeComercial() {
		return descricaoAtividadeComercial;
	}

	public void setDescricaoAtividadeComercial(String descricaoAtividadeComercial) {
		this.descricaoAtividadeComercial = descricaoAtividadeComercial;
	}	
}
