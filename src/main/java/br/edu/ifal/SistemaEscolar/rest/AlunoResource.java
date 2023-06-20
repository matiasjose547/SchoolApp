package br.edu.ifal.SistemaEscolar.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.ifal.SistemaEscolar.model.Boletim;
import br.edu.ifal.SistemaEscolar.model.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.SistemaEscolar.model.Aluno;
import br.edu.ifal.SistemaEscolar.repositories.AlunoRepository;

@RestController
@RequestMapping("/api/aluno")
public class AlunoResource {

	@Autowired
	private AlunoRepository alunoRepository;

	@RequestMapping(value = "/carregar", method = RequestMethod.GET)
	public String init() {

		Aluno a = new Aluno("252525",
				"Thamiris",
				"55544477788",
				 LocalDate.now(),
				"Cicero",
				"Selma");
		alunoRepository.save(a);
		return "Parabéns";
	}

	@RequestMapping(value = "/salvar")
	public Aluno salvar(@RequestBody Aluno aluno) {

		alunoRepository.save(aluno);

		return aluno;

	}

	@RequestMapping(value = "/{id}/buscar", method = RequestMethod.GET, produces = "application/json")
	public Aluno buscar(@PathVariable("id") Integer id) {
		return alunoRepository.getOne(id);
	}

	@RequestMapping(value = "/{id}/deletar", method = RequestMethod.GET, produces = "application/json")
	public String deletar(@PathVariable("id") Integer id) {
		alunoRepository.deleteById(id);
		return "Aluno deletado";
	}

	@RequestMapping(value = "/pesquisar/todos", method = RequestMethod.GET)
	public List<Aluno> listarAluno(@RequestParam(name = "nome", defaultValue = "ALL") String nome) {
		List<Aluno> lista = new ArrayList<>();
		lista = alunoRepository.findAll();
		return lista;

	}
}
