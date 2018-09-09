package br.edu.infnet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.model.Aluno;
import br.edu.infnet.repository.AlunoRepository;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("alunoMain");
		mav.addObject(new Aluno());
		mav.addObject("alunoTemp", new Aluno());
		mav.addObject("alunos", this.alunoRepository.findAll());
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("alunoMain");
		Optional<Aluno> aluno = this.alunoRepository.findById(id);
		aluno.ifPresent(obj -> mav.addObject("alunoTemp", obj));
		mav.addObject("aluno", aluno);
		mav.addObject("alunos", this.alunoRepository.findAll());
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.alunoRepository.deleteById(id);
		return "redirect:/aluno";
	}
	
	@PostMapping
	public String salvar(Aluno aluno) {
		this.alunoRepository.save(aluno);
		return "redirect:/aluno";
	}
	
	@ResponseBody
	@GetMapping("/list/getByNameStartingWith")
	public List<Aluno> findIdAsValueAndNomeAsDataByNomeStartingWith(@RequestParam("query") String query){
		List<Aluno> alunos = new ArrayList<>();
		alunos = this.alunoRepository.findByNomeStartingWith(query);
		return alunos;
	}
	
}
