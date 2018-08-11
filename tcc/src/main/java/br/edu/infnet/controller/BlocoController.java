package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.model.Curso;
import br.edu.infnet.repository.CursoRepository;

@Controller
@RequestMapping("/bloco")
public class BlocoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		
		ModelAndView mav = new ModelAndView("blocoMain");
		mav.addObject("cursos", this.cursoRepository.findAll()).addObject(new Curso());
		return mav;
		
	}
	
	@PostMapping
	public String salvar(Curso curso) {
		this.cursoRepository.save(curso);
		return "redirect:/bloco";
	}

}
