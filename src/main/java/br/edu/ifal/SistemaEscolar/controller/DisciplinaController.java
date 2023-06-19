package br.edu.ifal.SistemaEscolar.controller;

import java.util.List;

import jakarta.validation.Valid;

import br.edu.ifal.SistemaEscolar.repositories.AlunoRepository;
import br.edu.ifal.SistemaEscolar.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifal.SistemaEscolar.model.Disciplina;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	AlunoRepository alunoRepository;
	
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

	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveDisciplina(@Valid @ModelAttribute Disciplina disciplina, BindingResult result, ModelMap model) {

		System.out.println(disciplina);
 
		if (result.hasErrors()) {
			return "disciplina/form";
		}

		disciplinaRepository.saveAndFlush(disciplina);

		model.addAttribute("mensagem", "Disciplina " + disciplina.getNome() + " registrado com sucesso");

		return "redirect:/disciplina/list";
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public String deleteDisciplina(@RequestParam("disciplinaId") Integer id) {
		disciplinaRepository.deleteById(id);
		return "redirect:/disciplina/list";
	}
	

	@RequestMapping(value = { "/edit-{id}-disciplina" }, method = RequestMethod.GET)
	public String editDisciplina(@PathVariable("id") Integer id, ModelMap model) {
		Disciplina disciplina = disciplinaRepository.getOne(id);
		model.addAttribute("disciplina", disciplina);
		model.addAttribute("edit", true);

		return "disciplina/form";
	}

	
	@RequestMapping(value = { "/edit-{id}-disciplina" }, method = RequestMethod.POST)
	public String updateDisciplina(@Valid Disciplina disciplina, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "disciplina/form";
		}

		disciplinaRepository.saveAndFlush(disciplina);

		model.addAttribute("mensagem", "Disciplina " + disciplina.getNome() + " atualizado com sucesso");

		return "redirect:/disciplina/list";
	}

	
}
