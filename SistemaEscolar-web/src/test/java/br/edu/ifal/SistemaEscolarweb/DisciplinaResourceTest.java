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

import br.edu.ifal.SistemaEscolarweb.modelo.Disciplina;
import br.edu.ifal.SistemaEscolarweb.repositorios.DisciplinaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DisciplinaResourceTest {

	final String BASE_PATH = "http://localhost:8080/api/disciplina";

	@Autowired
	private DisciplinaRepository repositorio;

	private RestTemplate restTemplate;

	private ObjectMapper MAPPER = new ObjectMapper();

	@Before
	public void setUp() {
		
		restTemplate = new RestTemplate();
		repositorio.deleteAll();

		repositorio.save(new Disciplina("POO"));
		repositorio.save(new Disciplina("TI"));
		repositorio.save(new Disciplina("GQS"));
	}

	@Test
	public void deveFuncionarParaAListagemDeTodasAsDisciplinas() throws JsonMappingException, IOException {
		String response = restTemplate.getForObject(BASE_PATH + "/pesquisar/todos", String.class);

		List<Disciplina> disciplinas = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Disciplina.class));

		int tamanhoEsperadoDaLista = 3;

		assertEquals(tamanhoEsperadoDaLista, disciplinas.size());
	}
	@Test
	public void deveFuncionarParaSalvarUmaDisciplina() throws JsonMappingException, IOException {

		Disciplina disciplina = new Disciplina("POO");
		
		restTemplate.postForObject(BASE_PATH + "/salvar", disciplina, Disciplina.class);
		
		String response = restTemplate.getForObject(BASE_PATH + "/pesquisar/todos", String.class);
		
		List<Disciplina> disciplinas = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Disciplina.class));
		
		Assert.assertEquals("POO", disciplinas.get(3).getNome());
	}
	
	
	
}
