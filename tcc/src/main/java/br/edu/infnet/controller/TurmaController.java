package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.model.Turma;
import br.edu.infnet.repository.TurmaRepository;

@Controller
@RequestMapping("/turma")
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("turmaMain");
		mav.addObject(new Turma());
		mav.addObject("turmas", this.turmaRepository.findAll());
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("turmaMain");
		mav.addObject("turma", this.turmaRepository.findById(id));
		mav.addObject("turmas", this.turmaRepository.findAll());
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.turmaRepository.deleteById(id);
		return "redirect:/turma";
	}
	
	@PostMapping
	public String salvar(Turma turma) {
		this.turmaRepository.save(turma);
		return "redirect:/turma";
	}

}
