package br.edu.ifal.SistemaEscolar.controller;

import java.util.List;

import jakarta.validation.Valid;

import br.edu.ifal.SistemaEscolar.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifal.SistemaEscolar.model.Curso;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	CursoRepository cursoRepository;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listCurso(ModelMap model) {
		
		List<Curso> cursos = cursoRepository.findAll();
		model.addAttribute("cursoList", cursos);
		model.addAttribute("message", "Lista de Cursos");
		
	return "curso/list"; 
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newCurso(ModelMap model) {
		
		Curso curso = new Curso();
		model.addAttribute("curso", curso);
		model.addAttribute("edit", false);
		
		return "curso/form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCurso (@Valid @ModelAttribute Curso curso, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "curso/form";
		}
	
		cursoRepository.saveAndFlush(curso);
		
		model.addAttribute("mensagem", "Curso" + curso.getNome() + " registrado com sucesso");
		
		return "redirect:/curso/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public String deleteCurso(@RequestParam("cursoId") Integer id) {
			cursoRepository.deleteById(id);
			return "redirect:/curso/list";
	}

	@RequestMapping(value = { "/edit-{id}-curso" }, method = RequestMethod.GET)
	public String editCurso(@PathVariable("id") Integer codigo, ModelMap model) {
		Curso curso = cursoRepository.getOne(codigo);
		System.out.println(model.toString());
		model.addAttribute("curso", curso);
		model.addAttribute("edit", true);

		return "curso/form";
	}

	@RequestMapping(value = { "/edit-{id}-curso" }, method = RequestMethod.POST)
	public String updateCurso(@Valid Curso curso, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "curso/form";
		}

		cursoRepository.saveAndFlush(curso);

		model.addAttribute("mensagem", "Curso " + curso.getNome() + " atualizado com sucesso");

		return "redirect:/curso/list";
	}	
}
