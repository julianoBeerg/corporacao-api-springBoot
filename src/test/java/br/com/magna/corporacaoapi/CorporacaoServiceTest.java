package br.com.magna.corporacaoapi;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.corporacaoapi.record.DadosAtualizarAtividadeComercial;
import br.com.magna.corporacaoapi.record.DadosAtualizarCorporacao;
import br.com.magna.corporacaoapi.record.DadosAtualizarInstituicao;
import br.com.magna.corporacaoapi.record.DadosAtualizarNaturezaJuridica;
import br.com.magna.corporacaoapi.record.DadosAtualizarPorte;
import br.com.magna.corporacaoapi.record.DadosAtualizarSede;
import br.com.magna.corporacaoapi.record.DadosCadastrarAtividadeComercial;
import br.com.magna.corporacaoapi.record.DadosCadastrarCorporacao;
import br.com.magna.corporacaoapi.record.DadosCadastrarInstituicao;
import br.com.magna.corporacaoapi.record.DadosCadastrarNaturezaJuridica;
import br.com.magna.corporacaoapi.record.DadosCadastrarPorte;
import br.com.magna.corporacaoapi.record.DadosCadastrarSede;
import br.com.magna.corporacaoapi.record.DadosListarCorporacao;

//@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CorporacaoServiceTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testeCadastrar() {
		LocalDate dataFundacao = LocalDate.of(1918, 1, 9);
		DadosCadastrarInstituicao dadosCadastrarInstituicao = new DadosCadastrarInstituicao("Familiar",
				"Antonio Erminio de Moraes", dataFundacao, "teste", "teste", "teste");

		DadosCadastrarPorte dadosCadastrarPorte = new DadosCadastrarPorte("Grande Empresa");

		DadosCadastrarAtividadeComercial dadosCadastrarAtividadeComercial = new DadosCadastrarAtividadeComercial(
				4713004, "Lojas de departamentos ou magazines, exceto lojas francas (Duty free)");

		DadosCadastrarNaturezaJuridica dadosCadastrarNaturezaJuridica = new DadosCadastrarNaturezaJuridica(2046,
				"Sociedade Anônima Aberta");

		DadosCadastrarSede dadosCadastrarSede = new DadosCadastrarSede("Brasil", "SP", "Franca", "Rua 1", 100, 12345678,
				"Não");

		DadosCadastrarCorporacao dados = new DadosCadastrarCorporacao("51.082.582/0001-46", "Votorantim Participaçõess",
				"Votorantim", false, false, 20.0, 100, dadosCadastrarInstituicao, dadosCadastrarPorte,
				dadosCadastrarAtividadeComercial, dadosCadastrarNaturezaJuridica, dadosCadastrarSede, "test",
				ZonedDateTime.now());

		ResponseEntity<String> response = restTemplate.postForEntity("/corporacoes", dados, String.class);
		Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	void testeAtualizar() {

		DadosAtualizarInstituicao dadosAtualizarInstituicao = new DadosAtualizarInstituicao(null, "teste", "teste",
				"teste");

		DadosAtualizarPorte dadosAtualizarPorte = new DadosAtualizarPorte(null, "teste");

		DadosAtualizarAtividadeComercial dadosAtualizarAtividadeComercial = new DadosAtualizarAtividadeComercial(null,
				1234, "Teste");

		DadosAtualizarNaturezaJuridica dadosAtualizarNaturezaJuridica = new DadosAtualizarNaturezaJuridica(null, 1234,
				"Teste");

		DadosAtualizarSede dadosAtualizarSede = new DadosAtualizarSede(null, "teste", "teste", "teste", "teste", 123,
				87654321, "teste");

		DadosAtualizarCorporacao dadosAtualizarCorporacao = new DadosAtualizarCorporacao(null, "teste", true, true,
				10.0, 10, dadosAtualizarSede, dadosAtualizarPorte, dadosAtualizarAtividadeComercial,
				dadosAtualizarNaturezaJuridica, dadosAtualizarInstituicao);

		ResponseEntity<DadosListarCorporacao> response = restTemplate.exchange("/corporacoes", HttpMethod.PUT,
				new HttpEntity<>(dadosAtualizarCorporacao), DadosListarCorporacao.class);
		// Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testListar() {
		ResponseEntity<String> response = restTemplate.exchange("/listar", HttpMethod.GET, null, String.class);

		Assert.assertNotNull(response.getBody());
		Assert.assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	}

}
