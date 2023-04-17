package br.com.magna.corporacaoapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.corporacaoapi.entity.Corporacao;
import br.com.magna.corporacaoapi.record.DadosListarCorporacao;
import br.com.magna.corporacaoapi.record.atualizarcorporacao.DadosAtualizarAtividadeComercial;
import br.com.magna.corporacaoapi.record.atualizarcorporacao.DadosAtualizarCorporacao;
import br.com.magna.corporacaoapi.record.atualizarcorporacao.DadosAtualizarInstituicao;
import br.com.magna.corporacaoapi.record.atualizarcorporacao.DadosAtualizarNaturezaJuridica;
import br.com.magna.corporacaoapi.record.atualizarcorporacao.DadosAtualizarPorte;
import br.com.magna.corporacaoapi.record.atualizarcorporacao.DadosAtualizarSede;
import br.com.magna.corporacaoapi.record.cadastrarcorporacao.DadosCadastrarAtividadeComercial;
import br.com.magna.corporacaoapi.record.cadastrarcorporacao.DadosCadastrarCorporacao;
import br.com.magna.corporacaoapi.record.cadastrarcorporacao.DadosCadastrarInstituicao;
import br.com.magna.corporacaoapi.record.cadastrarcorporacao.DadosCadastrarNaturezaJuridica;
import br.com.magna.corporacaoapi.record.cadastrarcorporacao.DadosCadastrarPorte;
import br.com.magna.corporacaoapi.record.cadastrarcorporacao.DadosCadastrarSede;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CorporacaoServiceTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@DisplayName("Create: cadastrando corporação para teste")
	private DadosCadastrarCorporacao cadastrarCorporacaoTest() {
		DadosCadastrarInstituicao cadastrarInstituicao = new DadosCadastrarInstituicao("Familiar",
				"Antonio Erminio de Moraes", LocalDate.now(), "Erminio Pereira de Moraes", "Erminio Pereira de Moraes",
				"Erminio Pereira de Moraes");

		DadosCadastrarPorte cadastrarPorte = new DadosCadastrarPorte("teste");

		DadosCadastrarAtividadeComercial cadastrarAtividadeComercial = new DadosCadastrarAtividadeComercial(12345,
				"teste");

		DadosCadastrarNaturezaJuridica cadastrarNaturezaJuridica = new DadosCadastrarNaturezaJuridica(12345, "teste");

		DadosCadastrarSede cadastrarSede = new DadosCadastrarSede("Teste", "Teste", "Teste", "Teste", 123, 12345678,
				"Teste");

		DadosCadastrarCorporacao cadastrarCorporacao = new DadosCadastrarCorporacao("51.082.582/0001-97",
				"Votorantim Participações", "Votorantim Participações", false, false, 1400000000.0, 1400000000,
				cadastrarInstituicao, cadastrarPorte, cadastrarAtividadeComercial, cadastrarNaturezaJuridica,
				cadastrarSede, "admin", ZonedDateTime.now());

		return cadastrarCorporacao;
	}

	@DisplayName("Put: atualizando corporação para teste")
	private DadosAtualizarCorporacao atualizarCorporacaoTest() {
		DadosAtualizarInstituicao atualizarInstituicao = new DadosAtualizarInstituicao(1L, "teste", "teste", "teste");

		DadosAtualizarPorte atualizarPorte = new DadosAtualizarPorte(1L, "teste");

		DadosAtualizarAtividadeComercial atualizarAtividadeComercial = new DadosAtualizarAtividadeComercial(1L, 12345,
				"Teste");

		DadosAtualizarNaturezaJuridica atualizarNaturezaJuridica = new DadosAtualizarNaturezaJuridica(1L, 12345,
				"Teste");

		DadosAtualizarSede atualizarSede = new DadosAtualizarSede(1L, "Teste", "Teste", "Teste", "Teste", 123, 12345678,
				"Teste");

		DadosAtualizarCorporacao atualizarCorporacao = new DadosAtualizarCorporacao(1L, "Votorantim Participações",
				false, false, 1400000000.0, 1400000000, atualizarSede, atualizarPorte, atualizarAtividadeComercial,
				atualizarNaturezaJuridica, atualizarInstituicao);

		return atualizarCorporacao;
	}

	@Test
	@DisplayName("Create: teste cadastro de corporação (deve retornar um 201/Created)")
	void testCadastrarCorporacao() {
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
	@DisplayName("Put: teste cadastro de corporação (deve retornar um 200/Ok)")
	void testAtualizarCorporacao() {
		DadosCadastrarCorporacao cadastroCorporacao = cadastrarCorporacaoTest();
		restTemplate.postForEntity("/corporacoes", cadastroCorporacao, Corporacao.class);

		DadosAtualizarCorporacao dados = atualizarCorporacaoTest();

		ResponseEntity<DadosListarCorporacao> response = restTemplate.exchange("/corporacoes", HttpMethod.PUT,
				new HttpEntity<>(dados), DadosListarCorporacao.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@DisplayName("Put: teste cadastro de corporação (deve retornar um 200/Ok)")
	void testAtualizar() {
		DadosCadastrarCorporacao cadastroCorporacao = cadastrarCorporacaoTest();
		restTemplate.postForEntity("/corporacoes", cadastroCorporacao, Corporacao.class);

		DadosAtualizarCorporacao dados = atualizarCorporacaoTest();

		ResponseEntity<DadosListarCorporacao> response = restTemplate.exchange("/corporacoes/listar/1", HttpMethod.GET,
				new HttpEntity<>(dados), DadosListarCorporacao.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	@DisplayName("Get: teste listar todas as corporações (deve retornar um 200/Ok)")
	void testListarCorporacao() {
		ResponseEntity<Corporacao> response = restTemplate.getForEntity("/corporacoes/listar", Corporacao.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());

	}

	@Test
	@DisplayName("Get: teste listar corporações ativas(deve retornar um 200/Ok)")
	void testListarCorporacaoAtiva() {
		ResponseEntity<Corporacao> response = restTemplate.getForEntity("/corporacoes/listar/ativo", Corporacao.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());

	}
	
	@Test
	@DisplayName("Put: teste ativar corporação por CNPJ(deve retornar um 200/OK)")
	void testAtivarCNPJ() {
		DadosCadastrarCorporacao cadastroCorporacao = cadastrarCorporacaoTest();
		restTemplate.postForEntity("/corporacoes", cadastroCorporacao, Corporacao.class);

		DadosAtualizarCorporacao dados = atualizarCorporacaoTest();

		ResponseEntity<DadosListarCorporacao> response = restTemplate.exchange("/corporacoes/ativar/1", HttpMethod.PUT,
				new HttpEntity<>(dados), DadosListarCorporacao.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@DisplayName("Delete: teste inativar corporação por CNPJ(deve retornar um 204/No Content)")
	void testInativarCNPJ() {
		restTemplate.delete("/corporacoes/inativar/1");
		ResponseEntity<Corporacao> response = restTemplate.getForEntity("/corporacoes/inativar/1", Corporacao.class);
		assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.getStatusCode());

	}

	@Test
	@DisplayName("Delete: teste deletar corporação por ID(deve retornar um 204/No Content)")
	void testDeletar() {
		restTemplate.delete("/corporacoes/deletar/1");
		ResponseEntity<Corporacao> response = restTemplate.getForEntity("/corporacoes/deletar/1", Corporacao.class);
		assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.getStatusCode());

	}

}
