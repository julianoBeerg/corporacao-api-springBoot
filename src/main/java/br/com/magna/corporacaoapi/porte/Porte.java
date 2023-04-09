package br.com.magna.corporacaoapi.porte;

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



@Table(name = "tb_portes")
@Entity(name = "Porte")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Porte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "porte_id")
	private Long id;
	
	@Column(name = "tipo_porte")
	private String tipoPorte;
	
	public Porte(DadosCadastrarPorte dados) {
		this.id = dados.id();

	}

	public void atualizarInformacoesPorte(@Valid DadosAtualizarPorte dados) {
		if (dados.id() != null) {
			this.id = dados.id();
		}
		
	}
}
