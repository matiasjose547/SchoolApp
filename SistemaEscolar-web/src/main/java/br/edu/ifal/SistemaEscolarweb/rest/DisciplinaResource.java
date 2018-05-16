package br.edu.ifal.SistemaEscolarweb.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.SistemaEscolarweb.modelo.Disciplina;
import br.edu.ifal.SistemaEscolarweb.repositorios.DisciplinaRepository;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaResource {

	@Autowired
	DisciplinaRepository disciplinaRepository;

	@RequestMapping(value = "carregar", method = RequestMethod.GET)
	public String init() {
	    Disciplina d = new Disciplina("poo", null, null,null);
		disciplinaRepository.save(d);
		return "Parabéns";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Disciplina buscar(@PathVariable("id") Integer id) {
		return disciplinaRepository.getOne(id);
	}

	@RequestMapping(value = "/{id}/deletar", method = RequestMethod.GET, produces = "application/json")
	public String deletar(@PathVariable("id") Integer id) {
	 disciplinaRepository.deleteById(id);
		return "Disciplina deletada";

	}

	@RequestMapping(value = "/pesquisar/todos", method = RequestMethod.GET)
	public List<Disciplina> listarEscola(@RequestParam(name = "nome", defaultValue = "ALL") String nome) {
		List<Disciplina> lista = new ArrayList<>();
		lista = disciplinaRepository.findAll();
		return lista;

	}

}