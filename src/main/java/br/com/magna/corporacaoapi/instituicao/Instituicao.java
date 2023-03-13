package br.com.magna.corporacaoapi.instituicao;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tb_instituicoes")
@Entity(name = "Instituicao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Instituicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instituicao_id")
	private Long id;

	@Column(name = "tipo_instituicao")
	private String tipoInstituicao;

	private String fundador;

	@Column(name = "data_fundacao")
	private LocalDate dataFundacao;

	private String presidente;

	private String representante;

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
}
