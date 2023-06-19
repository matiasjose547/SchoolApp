package br.edu.ifal.SistemaEscolar.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.SistemaEscolar.model.Assunto;
import br.edu.ifal.SistemaEscolar.repositories.AssuntoRepository;

@RestController
@RequestMapping("/api/assunto")
public class AssuntoResource {

	@Autowired
	AssuntoRepository assuntoRepository;
	
	@RequestMapping(value = "/carregar", method = RequestMethod.GET)
	public String init() {
	    Assunto a = new Assunto("Equação","Aulas de matemática");
		assuntoRepository.save(a);
		return "Parabéns";
	}
	@RequestMapping(value = "/salvar", method = RequestMethod.POST )
	public Assunto salvar (@RequestBody Assunto assunto) {
		assuntoRepository.save(assunto);
		
		return assunto;
	}

	@RequestMapping(value = "/{id}/buscar", method = RequestMethod.GET, produces = "application/json")
	public Assunto buscar(@PathVariable("id") Integer id) {
		return assuntoRepository.getOne(id);
	}

	@RequestMapping(value = "/{id}/deletar", method = RequestMethod.GET, produces = "application/json")
	public String deletar(@PathVariable("id") Integer id) {
	 assuntoRepository.deleteById(id);
		return "Assunto deletado";

	}

	@RequestMapping(value = "/pesquisar/todos", method = RequestMethod.GET)
	public List<Assunto> listarEscola(@RequestParam(name = "nome", defaultValue = "ALL") String nome) {
		List<Assunto> lista = new ArrayList<>();
		lista = assuntoRepository.findAll();
		return lista;

	}

}