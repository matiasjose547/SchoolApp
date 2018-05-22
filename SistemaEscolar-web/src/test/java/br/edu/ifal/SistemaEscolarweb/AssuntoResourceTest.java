package br.edu.ifal.SistemaEscolarweb;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifal.SistemaEscolarweb.modelo.Aluno;
import br.edu.ifal.SistemaEscolarweb.modelo.Assunto;
import br.edu.ifal.SistemaEscolarweb.repositorios.AssuntoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AssuntoResourceTest {


	final String BASE_PATH = "http://localhost:8080/api/assunto";

	@Autowired
	private AssuntoRepository repositorio;

	private RestTemplate restTemplate;

	private ObjectMapper MAPPER = new ObjectMapper();

	@Before
	public void setUp() {

		restTemplate = new RestTemplate();
		repositorio.deleteAll();

		repositorio.save(new Assunto("Equção", "Matemática"));
		repositorio.save(new Assunto("Fotossíntese", "Plantas"));
		repositorio.save(new Assunto("Redação", "Português"));
	}

	@Test
	public void deveFuncionarParaAListagemDeTodosOsAssuntos() throws JsonMappingException, IOException {
		String response = restTemplate.getForObject(BASE_PATH + "/pesquisar/todos", String.class);

		List<Assunto> assuntos = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Assunto.class));

		int tamanhoEsperadoDaLista = 3;

		assertEquals(tamanhoEsperadoDaLista, assuntos.size());
	}

	
	@Test
	public void deveFuncionarParaSalvarUmAssunto() throws JsonMappingException, IOException {

		Assunto assunto = new Assunto("Nis", "Redes");
		
		restTemplate.postForObject(BASE_PATH + "/salvar", assunto, Assunto.class);
		
		String response = restTemplate.getForObject(BASE_PATH + "/pesquisar/todos", String.class);
		
		List<Assunto> assuntos = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Assunto.class));
		
		Assert.assertEquals("Nis", assuntos.get(3).getNome());	
}
}
