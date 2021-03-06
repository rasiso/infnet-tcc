package br.edu.infnet.controller;

import java.util.ArrayList;
import java.util.List;

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
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("cursoMain");
		mav.addObject("curso", this.cursoRepository.findById(id));
		mav.addObject("cursos", this.cursoRepository.findAll());
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.cursoRepository.deleteById(id);
		return "redirect:/curso";
	}
	
	@PostMapping
	public String salvar(Curso curso) {
		this.cursoRepository.save(curso);
		return "redirect:/curso";
	}
	
	@ResponseBody
	@GetMapping("/list/getByNameStartingWith")
	public List<Curso> findIdAsValueAndNomeAsDataByNomeStartingWith(@RequestParam("query") String query){
		List<Curso> cursos = new ArrayList<>();
		cursos = this.cursoRepository.findByNomeStartingWith(query);
		return cursos;
	}
	
}
