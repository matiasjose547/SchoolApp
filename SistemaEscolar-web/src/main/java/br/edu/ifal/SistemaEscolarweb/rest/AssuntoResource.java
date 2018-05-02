package br.edu.ifal.SistemaEscolarweb.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.SistemaEscolarweb.modelo.Assunto;
import br.edu.ifal.SistemaEscolarweb.repositorios.AssuntoRepository;

@RestController
@RequestMapping("/assunto")
public class AssuntoResource {

	@Autowired
	AssuntoRepository AssuntoRepository;

	@RequestMapping(value = "carregar", method = RequestMethod.GET)
	public String init() {
	    Assunto a = new assunto("poo", null, null,null);
		AssuntoRepository.save(a);
		return "Parabéns";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Disciplina buscar(@PathVariable("id") Integer id) {
		return assuntoRepository.getOne(id);
	}

	@RequestMapping(value = "/{id}/deletar", method = RequestMethod.GET, produces = "application/json")
	public String deletar(@PathVariable("id") Integer id) {
	 assuntoRepository.deleteById(id);
		return "Assunto deletado";

	}

	@RequestMapping(value = "/pesquisar", method = RequestMethod.GET)
	public List<Assunto> listarEscola(@RequestParam(name = "nome", defaultValue = "ALL") String nome) {
		List<Assunto> lista = new ArrayList<>();
		lista = assuntoRepository.findAll();
		return lista;

	}

}