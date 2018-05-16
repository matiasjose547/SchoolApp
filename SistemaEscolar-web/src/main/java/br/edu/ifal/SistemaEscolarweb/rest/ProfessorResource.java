package br.edu.ifal.SistemaEscolarweb.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.SistemaEscolarweb.modelo.Professor;
import br.edu.ifal.SistemaEscolarweb.repositorios.ProfessorRepository;

@RestController
@RequestMapping("/api/professor")
public class ProfessorResource {

	@Autowired
	ProfessorRepository professorRepository;

	@RequestMapping(value = "carregar", method = RequestMethod.GET)
	public String init() {
		Professor p = new Professor("Edvaldo", "123456789", 4, "ING");
		professorRepository.save(p);
		return "Parabéns";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Professor buscar(@PathVariable("id") Integer id) {
		return professorRepository.getOne(id);
	}

	@RequestMapping(value = "/{id}/deletar", method = RequestMethod.GET, produces = "application/json")
	public String deletar(@PathVariable("id") Integer id) {
		professorRepository.deleteById(id);
		return "Professor deletado";

	}

	@RequestMapping(value = "/pesquisar/todos", method = RequestMethod.GET)
	public List<Professor> listarProfessor(@RequestParam(name = "nome", defaultValue = "ALL") String nome) {
		List<Professor> lista = new ArrayList<>();
		lista = professorRepository.findAll();
		return lista;

	}

}
