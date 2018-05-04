
package br.edu.ifal.SistemaEscolarweb;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifal.SistemaEscolarweb.modelo.Professor;
import br.edu.ifal.SistemaEscolarweb.repositorios.ProfessorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProfessorResourceTest {
    final String BASE_PATH ="http://localhost:8080/professor";
	@Autowired
	private ProfessorRepository repositorio;
	private RestTemplate restTemplate;
    private ObjectMapper MAPPER = new ObjectMapper();
    
    
    @Before
    public void setUp() {
    	repositorio.deleteAll();
    	
    	repositorio.save(new Professor ("jose" ,"000.000.000-00" ,111 ,"Ciencias da computação "));
    	repositorio.save(new Professor ("joão" ,"111.111.111-11" ,222 ,"Física "));
    	repositorio.save(new Professor ("Maria" ,"222.222.222-22" ,333 ,"Matemática "));
    	
    	restTemplate=new RestTemplate();
    }
    
    
    @Test
	public void deveFumcionarAListagemDeTodosOsProfessores() throws JsonParseException, JsonMappingException, IOException {
    	String resposta = restTemplate.getForObject(BASE_PATH +"/pesquisar", String.class);
    	
    	List<Professor> professores = MAPPER.readValue(resposta, MAPPER.getTypeFactory().constructCollectionLikeType(List.class , Professor.class));
    	
    	int tamanhoDaListaDeProfessorEsperado = 3;
    	assertEquals(tamanhoDaListaDeProfessorEsperado, professores.size());
    }

}
