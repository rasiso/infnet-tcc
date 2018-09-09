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
import br.edu.infnet.model.Professor;
import br.edu.infnet.repository.ProfessorRepository;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("professorMain");
		mav.addObject(new Professor());
		mav.addObject("professorTemp", new Aluno());
		mav.addObject("professores", this.professorRepository.findAll());
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("professorMain");
		Optional<Professor> professor = this.professorRepository.findById(id);
		professor.ifPresent(obj -> mav.addObject("professorTemp", obj));
		mav.addObject("professor", professor);
		mav.addObject("professores", this.professorRepository.findAll());
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.professorRepository.deleteById(id);
		return "redirect:/professor";
	}
	
	@PostMapping
	public String salvar(Professor professor) {
		this.professorRepository.save(professor);
		return "redirect:/professor";
	}
	
	@ResponseBody
	@GetMapping("/list/getByNameStartingWith")
	public List<Professor> findIdAsValueAndNomeAsDataByNomeStartingWith(@RequestParam("query") String query){
		List<Professor> professores = new ArrayList<>();
		professores = this.professorRepository.findByNomeStartingWith(query);
		return professores;
	}
	

}
