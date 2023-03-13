package br.com.magna.corporacaoapi.corporacao;

import br.com.magna.corporacaoapi.instituicao.Instituicao;
import br.com.magna.corporacaoapi.sede.Sede;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tb_corporacoes")
@Entity(name = "Corporacao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Corporacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "corporacao_id")
	private Long id;

	private String cnpj;

	@Column(name = "razao_social")
	private String razaoSocial;

	@Column(name = "nome_fantasia")
	private String nomeFantasia;

	@Column(name = "tipo_publico")
	private Boolean tipoPublico;

	private Boolean multinacional;

	@Column(name = "cnpj_ativo")
	private Boolean cnpjAtivo;

	private Double faturamento;

	@JoinColumn(name = "num_funcionarios")
	private Integer numFuncionarios;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "instituicao_id")
	private Instituicao instituicao;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "sede_id")
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
		if (dados.dadosAtualizarSede() != null) {
			this.sede.atualizarInformacoesSede(dados.dadosAtualizarSede());
		}
	}

	public void inativarCnpj() {
		this.cnpjAtivo = false;
	}

}
