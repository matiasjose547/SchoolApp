package br.edu.ifal.SistemaEscolarweb;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Date;
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
import br.edu.ifal.SistemaEscolarweb.repositorios.AlunoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AlunoResourceTest {


	final String BASE_PATH = "http://localhost:8080/api/aluno";

	@Autowired
	private AlunoRepository repositorio;

	private RestTemplate restTemplate;

	private ObjectMapper MAPPER = new ObjectMapper();

	@Before
	public void setUp() {
		
		restTemplate = new RestTemplate();
		repositorio.deleteAll();

		repositorio.save(new Aluno("Didil", "1236", ""));
		repositorio.save(new Aluno("Brenda", "1446", ""));
		repositorio.save(new Aluno("MAria", "1874", ""));
	}

	@Test
	public void deveFuncionarParaAListagemDeTodosOsAlunos() throws JsonMappingException, IOException {
		String response = restTemplate.getForObject(BASE_PATH + "/pesquisar/todos", String.class);

		List<Aluno> alunos = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Aluno.class));

		int tamanhoEsperadoDaLista = 3;

		assertEquals(tamanhoEsperadoDaLista, alunos.size());
	}

	
	@Test
	public void deveFuncionarParaSalvarUmAluno() throws JsonMappingException, IOException {
		
		Aluno aluno = new Aluno("JR", "15641654", "date");
		
		restTemplate.postForObject(BASE_PATH + "/salvar", aluno, Aluno.class);
		
		String response = restTemplate.getForObject(BASE_PATH + "/pesquisar/todos", String.class);
		
		List<Aluno> alunos = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Aluno.class));
		
		Assert.assertEquals("JR", alunos.get(3).getNome());
	}
}
