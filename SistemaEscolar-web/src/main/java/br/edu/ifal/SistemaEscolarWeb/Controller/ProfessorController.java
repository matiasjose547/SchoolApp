package br.edu.ifal.SistemaEscolarWeb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifal.SistemaEscolarweb.modelo.Professor;
import br.edu.ifal.SistemaEscolarweb.repositorios.DisciplinaRepository;
import br.edu.ifal.SistemaEscolarweb.repositorios.ProfessorRepository;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	ProfessorRepository professorRepository;
	@Autowired
	DisciplinaRepository disciplinaRepository;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAluno(ModelMap model) {

		List<Professor> professores = professorRepository.findAll();

		model.addAttribute("professorList", professores);

		model.addAttribute("message", "Lista de Professores");

		return "professor/list";
	}
}
