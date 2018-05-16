package br.edu.ifal.SistemaEscolarweb;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

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
import br.edu.ifal.SistemaEscolarweb.modelo.Disciplina;
import br.edu.ifal.SistemaEscolarweb.modelo.Escola;
import br.edu.ifal.SistemaEscolarweb.repositorios.AlunoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AlunoResourceTest {


	final String BASE_PATH = "http://localhost:8080/aluno";

	@Autowired
	private AlunoRepository repositorio;

	private RestTemplate restTemplate;

	private ObjectMapper MAPPER = new ObjectMapper();

	@Before
	public void setUp() {

		restTemplate = new RestTemplate();
		repositorio.deleteAll();

		repositorio.save(new Aluno("Didil", "1235468646", "1231-25-21"));
		repositorio.save(new Aluno("Brenda", "1236251446", "1231-25-21"));
		repositorio.save(new Aluno("MAria", "1235467874", "1231-25-21"));
	}

	@Test
	public void deveFuncionarParaAListagemDeTodasAsEscolas() throws JsonMappingException, IOException {
		String response = restTemplate.getForObject(BASE_PATH + "/pesquisar/todos", String.class);

		List<Aluno> alunos = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Disciplina.class));

		int tamanhoEsperadoDaLista = 3;

		assertEquals(tamanhoEsperadoDaLista, alunos.size());
	}

	
}
