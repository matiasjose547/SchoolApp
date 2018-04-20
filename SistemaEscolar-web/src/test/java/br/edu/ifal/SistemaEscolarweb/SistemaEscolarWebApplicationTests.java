package br.edu.ifal.SistemaEscolarweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.ifal.SistemaEscolarweb.modelo.Curso;
import br.edu.ifal.SistemaEscolarweb.repositorios.CursoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SistemaEscolarWebApplicationTests {

	@Autowired
	private CursoRepository cursoRepository;

	@Test
	public void contextLoads() {
		
		Curso c = new Curso(2, "Informatica");
		
		
		cursoRepository.save(c);
		
	}

}
