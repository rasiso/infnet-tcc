package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.model.Curso;
import br.edu.infnet.repository.CursoRepository;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("cursoMain");
		mav.addObject(new Curso());
		mav.addObject("cursos", this.cursoRepository.findAll());
		return mav;
	}
	
	@GetMapping("/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("cursoMain");
		mav.addObject("curso", this.cursoRepository.findById(id));
		mav.addObject("cursos", this.cursoRepository.findAll());
		mav.addObject("method", "PUT");
		return mav;
	}
		
	@PostMapping
	public String salvar(Curso curso) {
		this.cursoRepository.save(curso);
		return "redirect:/curso";
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.cursoRepository.deleteById(id);
		return "redirect:/curso";
	}
	
	@PutMapping
	public String editar(Curso curso) {
		return this.salvar(curso);
	}

}
