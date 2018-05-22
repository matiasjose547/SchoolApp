package br.edu.ifal.SistemaEscolarweb.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.SistemaEscolarweb.modelo.Aluno;
import br.edu.ifal.SistemaEscolarweb.modelo.Curso;
import br.edu.ifal.SistemaEscolarweb.repositorios.CursoRepository;

@RestController
@RequestMapping("/api/curso")
public class CursoResouce {

	@Autowired
	CursoRepository cursoRepository;

	@RequestMapping(value = "carregar", method = RequestMethod.GET)
	public String init() {
		Curso c = new Curso(5, "IFREE-RL");
		cursoRepository.save(c);
		return "Salvo com sucesso";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Curso buscar(@PathVariable("id") Integer id) {
		return cursoRepository.getOne(id);
	}

	@RequestMapping(value = "/{id}/deletar", method = RequestMethod.GET, produces = "application/json")
	public String deletar(@PathVariable("id") Integer id) {
		cursoRepository.deleteById(id);
		return "Escola deletada";

	}

	@RequestMapping(value = "/pesquisar/todos", method = RequestMethod.GET)
	public List<Curso> listarEscola(@RequestParam(name = "nome", defaultValue = "ALL") String nome) {
		List<Curso> lista = new ArrayList<>();
		lista = cursoRepository.findAll();
		return lista;

	}
	@RequestMapping(value = "/salvar", method=RequestMethod.POST)
	public Curso salvar(@RequestBody Curso curso) {
		
		cursoRepository.save(curso);
		
		return curso;
		
	}

}
