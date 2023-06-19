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
import br.edu.ifal.SistemaEscolarweb.modelo.Escola;
import br.edu.ifal.SistemaEscolarweb.repositorios.EscolaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EscolaResourceTest {

	final String BASE_PATH = "http://localhost:8080/api/escola";

	@Autowired
	private EscolaRepository repositorio;

	private RestTemplate restTemplate;

	private ObjectMapper MAPPER = new ObjectMapper();

	@Before
	public void setUp() {

		restTemplate = new RestTemplate();
		repositorio.deleteAll();

		repositorio.save(new Escola("IFAL RL"));
		repositorio.save(new Escola("IFAL SATUBA"));
		repositorio.save(new Escola("asdadsa"));
	}

	@Test
	public void deveFuncionarParaAListagemDeTodasAsEscolas() throws JsonMappingException, IOException {
		String response = restTemplate.getForObject(BASE_PATH + "/pesquisar/todos", String.class);

		List<Escola> escolas = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Escola.class));

		int tamanhoEsperadoDaLista = 3;

		assertEquals(tamanhoEsperadoDaLista, escolas.size());
	}
	
	@Test
	public void deveFuncionarParaSalvarUmAluno() throws JsonMappingException, IOException {

		Escola escola = new Escola("Ifal");
		
		restTemplate.postForObject(BASE_PATH + "/salvar", escola, Escola.class);
		
		String response = restTemplate.getForObject(BASE_PATH + "/pesquisar/todos", String.class);
		
		List<Escola> escolas = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Escola.class));
		
		Assert.assertEquals("Ifal", escolas.get(3).getNome());
	}

}
