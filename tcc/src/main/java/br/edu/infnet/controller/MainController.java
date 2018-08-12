package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.model.Curso;
import br.edu.infnet.repository.CursoRepository;
import br.edu.infnet.service.UsuarioService;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@GetMapping
	public ModelAndView listar() {
		
		ModelAndView mav = new ModelAndView("main");
		//mav.addObject("main", this.cursoRepository.findAll()).addObject(new Curso());
		return mav;
		
	}
	
	@PostMapping
	public String salvar(Curso curso) {
		this.cursoRepository.save(curso);
		return "redirect:/curso";
	}

}
