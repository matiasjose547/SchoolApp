package br.edu.ifal.SistemaEscolarWeb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifal.SistemaEscolarweb.modelo.Aluno;
import br.edu.ifal.SistemaEscolarweb.modelo.Disciplina;
import br.edu.ifal.SistemaEscolarweb.modelo.Professor;
import br.edu.ifal.SistemaEscolarweb.repositorios.DisciplinaRepository;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listDisciplina(ModelMap model) {

		List<Disciplina> disciplinas = disciplinaRepository.findAll();

		model.addAttribute("disciplinaList", disciplinas);

		model.addAttribute("message", "Lista de disciplinas");

		return "disciplina/list";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String salvar(ModelMap model) {
		
		Disciplina disciplina = new Disciplina();
		model.addAttribute("disciplina", disciplina);
		model.addAttribute("edit", false);
		
		return "disciplina/form";
	}

	
	
}
