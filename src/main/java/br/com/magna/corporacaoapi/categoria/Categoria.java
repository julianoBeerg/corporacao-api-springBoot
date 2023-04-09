package br.com.magna.corporacaoapi.categoria;

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

@Table(name = "tb_categorias")
@Entity(name = "Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoria_id")
	private Long id;

	@Column(name = "codigo_natureza_juridica")
	private Integer codigoNaturezaJuridica;

	@Column(name = "descricao_natureza_juridica")
	private String descricaoNaturezaJuridica;

	@Column(name = "codigo_atividade_comercial")
	private Integer codigoAtividadeComercial;

	@Column(name = "descricao_atividade_comercial")
	private String descricaoAtividadeComercial;

	public Categoria(DadosCadastrarCategoria dados) {
		this.codigoNaturezaJuridica = dados.codigoNaturezaJuridica();
		this.descricaoNaturezaJuridica = dados.descricaoNaturezaJuridica();
		this.codigoAtividadeComercial = dados.codigoAtividadeComercial();
		this.descricaoAtividadeComercial = dados.descricaoAtividadeComercial();

	}

	public void atualizarInformacoesCategoria(@Valid DadosAtualizarCategoria dados) {
		if (dados.codigoAtividadeComercial() != null) {
			this.codigoNaturezaJuridica = dados.codigoNaturezaJuridica();
		}
		if (dados.descricaoNaturezaJuridica() != null) {
			this.descricaoNaturezaJuridica = dados.descricaoNaturezaJuridica();
		}
		if (dados.codigoAtividadeComercial() != null) {
			this.codigoAtividadeComercial = dados.codigoAtividadeComercial();
		}
		if (dados.descricaoAtividadeComercial() != null) {
			this.descricaoAtividadeComercial = dados.descricaoAtividadeComercial();
		}

	}
}
