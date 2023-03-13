package br.com.magna.corporacaoapi.sede;

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

@Table(name = "tb_sedes")
@Entity(name = "Sede")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sede {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sede_id")
	private Long id;

	private String pais;

	private String uf;

	private String cidade;

	private String logradouro;

	private Integer numero;

	private Integer cep;

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
}
