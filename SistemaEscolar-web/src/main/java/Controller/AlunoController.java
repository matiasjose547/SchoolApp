package Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifal.SistemaEscolarweb.modelo.Aluno;
import br.edu.ifal.SistemaEscolarweb.repositorios.AlunoRepository;

@Controller
@RequestMapping("/ctl/aluno")
public class AlunoController {
	

	@Autowired
	AlunoRepository alunoRepository;
	
	@RequestMapping(value= "/list", method=RequestMethod.GET)
	public String listAluno(ModelMap model) {
		
		List<Aluno> alunos = alunoRepository.findAll();
		
		model.addAttribute("alunosList", alunos);
		
		model.addAttribute("message", "Lista de alunos");
		System.out.println("list");
		
		return "/aluno/list";
	}
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newAluno(ModelMap model) {
		
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		model.addAttribute("edit", false);
		
		return "aluno/form";
	}
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveAluno(@Valid @ModelAttribute Aluno aluno, BindingResult result,
							ModelMap model) {
		if (result.hasErrors()) {
			return "aluno/form";
		}
		
		alunoRepository.saveAndFlush(aluno);
		
		model.addAttribute("mensagem", "Aluno " + aluno.getNome() + " registrado com sucesso");
		
		return "redirect:/aluno/list";
	}
	
	@RequestMapping(value = { "/edit-{id}-aluno" }, method = RequestMethod.GET)
	public String editAluno(@PathVariable("id") Integer id, ModelMap model) {
		Aluno aluno = alunoRepository.getOne(id);
		model.addAttribute("aluno", aluno);
		model.addAttribute("edit", true);
		return "aluno/form";
	}
	
	@RequestMapping(value = { "/edit-{id}-aluno" }, method = RequestMethod.POST)
	public String updateAluno(@Valid Aluno aluno, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "aluno/form";
		}
		
		alunoRepository.saveAndFlush(aluno);
		
		model.addAttribute("mensagem", "Aluno " + aluno.getNome() + " atualizado com sucesso");
		
		return "redirect:/aluno/list";
	}
	
	@RequestMapping(value = { "/delete-{id}-aluno" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable Integer id) {
		alunoRepository.deleteById(id);
		return "redirect:/aluno/list";
	}

}
