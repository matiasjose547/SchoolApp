package br.edu.ifal.SistemaEscolarweb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.SistemaEscolarweb.modelo.Boletim;
import br.edu.ifal.SistemaEscolarweb.modelo.Nota;
import br.edu.ifal.SistemaEscolarweb.repositorios.BoletimRepository;


@RestController
@RequestMapping("/api/assunto")
public class BoletimResource {

	@Autowired
	BoletimRepository boletimRepository;
	
	@RequestMapping(value = "carregar", method = RequestMethod.GET)
	public String init() {
		//Nota n = new Nota(21,5.5/);
		Boletim b = new Boletim();
		boletimRepository.save(b);
		return "Tudo certo";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Boletim buscar(@PathVariable("id") Integer id) {
		return boletimRepository.getOne(id);
	}
}
