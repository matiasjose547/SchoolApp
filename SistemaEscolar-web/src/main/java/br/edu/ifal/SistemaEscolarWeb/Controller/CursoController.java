package br.edu.ifal.SistemaEscolarWeb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
}
