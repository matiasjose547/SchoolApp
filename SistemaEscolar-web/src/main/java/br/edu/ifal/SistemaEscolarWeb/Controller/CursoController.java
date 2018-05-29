package br.edu.ifal.SistemaEscolarWeb.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifal.SistemaEscolarweb.modelo.Curso;
import br.edu.ifal.SistemaEscolarweb.repositorios.CursoRepository;

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
	
	public String newCurso(ModelMap model) {
		
		Curso curso = new Curso();
		model.addAttribute("curso", "curso");
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
}

