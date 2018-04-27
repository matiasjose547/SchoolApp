package br.edu.ifal.SistemaEscolarweb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.SistemaEscolarweb.modelo.Escola;
import br.edu.ifal.SistemaEscolarweb.repositorios.EscolaRepository;

@RestController
@RequestMapping("/Escola")
public class EscolaResource {
	@Autowired
	EscolaRepository escolaRepository;

	@RequestMapping(value = "carregar", method = RequestMethod.GET)
	public String init() {
		Escola e = new Escola(9, "IFAL-RL");
		escolaRepository.save(e);
		return "Tudo certo";
	}

	@RequestMapping(value = "buscar", method = RequestMethod.GET)
	public Escola buscar(@PathVariable("9") Integer id) {
		return escolaRepository.getOne(id);
	}
	

}
