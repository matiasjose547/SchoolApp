package br.edu.ifal.SistemaEscolarweb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.SistemaEscolarweb.modelo.Curso;
import br.edu.ifal.SistemaEscolarweb.repositorios.CursoRepository;

@RestController
@RequestMapping("/api/curso")
public class CursoResouce {

	@Autowired
	CursoRepository cursoRepository;

	@GetMapping(value = "/carregar")
	public String init() {
		Curso c = new Curso(5, "IFREE-RL");
		cursoRepository.save(c);
		return "Salvo com sucesso";
	}

	@GetMapping("/{id}")
	public Curso buscar(@PathVariable("id") Integer id) {
		return cursoRepository.getOne(id);
	}

	@DeleteMapping("/{id}/deletar")
	public String deletar(@PathVariable("id") Integer id) {
		cursoRepository.deleteById(id);
		return "Curso deletado";
	}

	@GetMapping("/list")
	public List listarEscola() {
		List lista = cursoRepository.findAll();
		return lista;
	}
	
	@RequestMapping(value = "/salvar", method=RequestMethod.POST)
	public Curso salvar(@RequestBody Curso curso) {
		
		cursoRepository.save(curso);
		
		return curso;
		
	}

}
