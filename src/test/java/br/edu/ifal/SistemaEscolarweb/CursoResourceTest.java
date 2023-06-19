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

import br.edu.ifal.SistemaEscolarweb.modelo.Curso;
import br.edu.ifal.SistemaEscolarweb.repositorios.CursoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CursoResourceTest {

	final String BASE_PATH = "http://localhost:8080/api/curso";

	@Autowired
	private CursoRepository repositorio;

	private RestTemplate restTemplate;

	private ObjectMapper MAPPER = new ObjectMapper();

	@Before
	public void setUp() {

		restTemplate = new RestTemplate();
		repositorio.deleteAll();

		repositorio.save(new Curso(1,"INFORMÁTICA"));
		repositorio.save(new Curso(2,"REDES"));
		repositorio.save(new Curso(3,"PORTUGUÊS"));
	}

	@Test
	public void deveFuncionarParaAListagemDeTodasAsEscolas() throws JsonMappingException, IOException {
		String response = restTemplate.getForObject(BASE_PATH + "/pesquisar/todos", String.class);

		List<Curso> cursos = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Curso.class));

		int tamanhoEsperadoDaLista = 3;

		assertEquals(tamanhoEsperadoDaLista, cursos.size());
	}
	
	@Test
	public void deveFuncionarParaSalvarUmCurso() throws JsonMappingException, IOException {

		Curso curso = new Curso(1, "Informatica");
		
		restTemplate.postForObject(BASE_PATH + "/salvar",curso , Curso.class);
		
		String response = restTemplate.getForObject(BASE_PATH + "/pesquisar/todos", String.class);
		
		List<Curso> cursos = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Curso.class));
		
		Assert.assertEquals("Informatica", cursos.get(3).getNome());
	}
	

}
