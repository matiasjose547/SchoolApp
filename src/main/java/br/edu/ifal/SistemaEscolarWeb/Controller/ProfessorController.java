package br.edu.ifal.SistemaEscolarWeb.Controller;

import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifal.SistemaEscolarweb.modelo.Disciplina;
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
	public String listProfessor(ModelMap model) {

		List<Professor> professores = professorRepository.findAll();

		model.addAttribute("professorList", professores);

		model.addAttribute("message", "Lista de Professores");

		return "professor/list";
	}
	

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newProfessor(ModelMap model) {

		Professor professor = new Professor();
		model.addAttribute("professor", professor);
		model.addAttribute("edit", false);

		return "professor/form";
	}
	
	@RequestMapping(value = {"/save"}, method = RequestMethod.POST)
	public String saveProfessor(@Valid @ModelAttribute Professor professor, 
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "professor/list";
		}
		
		professorRepository.saveAndFlush(professor);
		
		model.addAttribute("mensagem", "Professor" + professor.getNome() + " registrado com sucesso");

		return "redirect:/professor/list";
		
	}
	
	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public String deleteProfessor(@RequestParam("professorId") Integer numeroCadastro) {
		professorRepository.deleteById(numeroCadastro);
		return "redirect:/professor/list";
	}
	

	@RequestMapping(value = { "/edit-{id}-professor" }, method = RequestMethod.GET)
	public String editProfessor(@PathVariable("id") Integer id, ModelMap model) {
		Professor professor = professorRepository.getOne(id);
		model.addAttribute("professor", professor);
		model.addAttribute("edit", true);

		return "professor/form";
	}

	
	@RequestMapping(value = { "/edit-{id}-professor" }, method = RequestMethod.POST)
	public String updateProfessor(@Valid Professor professor, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "professor/form";
		}

		professorRepository.saveAndFlush(professor);

		model.addAttribute("mensagem", "Professor " + professor.getNome() + " atualizado com sucesso");

		return "redirect:/professor/list";
	}
}
