package br.edu.ifal.SistemaEscolarweb.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.SistemaEscolarweb.modelo.Escola;
import br.edu.ifal.SistemaEscolarweb.repositorios.EscolaRepository;

@RestController
@RequestMapping("/escola")
public class EscolaResource {
	@Autowired
	EscolaRepository escolaRepository;

	@RequestMapping(value = "carregar", method = RequestMethod.GET)
	public String init() {
		Escola a = new Escola();
		a.setNome("Claudizete");
		escolaRepository.save(a);
		return "Tudo certo";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Escola buscar(@PathVariable("id") Integer id) {
		return escolaRepository.getOne(id);
	}

	@RequestMapping(value = "/{id}/deletar", method = RequestMethod.GET, produces = "application/json")
	public String deletar(@PathVariable("id") Integer id) {
		escolaRepository.deleteById(id);
		return "Escola deletada";
	}

	@RequestMapping(value = "/pesquisar/todos", method = RequestMethod.GET)
	public List<Escola> listarEscola(@RequestParam(name = "nome", defaultValue = "ALL") String nome) {
		List<Escola> lista = new ArrayList<>();
		lista = escolaRepository.findAll();
		return lista;

	}

}
