package br.edu.infnet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.model.Formulario;
import br.edu.infnet.model.Professor;
import br.edu.infnet.model.Turma;
import br.edu.infnet.repository.FormularioRepository;

@Controller
@RequestMapping("/formulario")
public class FormularioController {

	@Autowired
	private FormularioRepository formularioRepository;
	
	@ResponseBody
	@GetMapping("/json/{id}")
	public Optional<Formulario> getJsonById(@PathVariable long id) {
		//ModelAndView mav = new ModelAndView("formularioMain");
		//mav.addObject(new Formulario());
		Optional<Formulario> formulario = this.formularioRepository.findById(id);
		//mav.addObject("formulario", this.formularioRepository.findById(id));
		return formulario;
	}
	
	@GetMapping("/{id}")
	public ModelAndView getById(@PathVariable long id) {
		ModelAndView mav = new ModelAndView("formularioMain");
		mav.addObject(new Formulario());
		//Optional<Formulario> formulario = this.formularioRepository.findById(id);b
		//mav.addObject("formulario", this.formularioRepository.findById(id));
		Optional<Formulario> formulario = this.formularioRepository.findById(id);
		formulario.ifPresent(obj -> mav.addObject("formulario", obj));
		return mav;
	}
	
	/*@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("formularioMain");
		Optional<Turma> formulario = this.formularioRepository.findById(id);
		formulario.ifPresent(obj -> mav.addObject("formularioTemp", obj));
		mav.addObject("formulario", this.formularioRepository.findById(id));
		mav.addObject("formularios", this.formularioRepository.findAll());
		return mav;
	}*/
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.formularioRepository.deleteById(id);
		return "redirect:/formulario";
	}
	
	@PostMapping
	public String salvar(Formulario formulario) {
		this.formularioRepository.save(formulario);
		return "redirect:/formulario";
	}
	
	@ResponseBody
	@GetMapping("/list/getByNameStartingWith")
	public List<Turma> findIdAsValueAndNomeAsDataByNomeStartingWith(@RequestParam("query") String query){
		List<Turma> formularios = new ArrayList<>();
		//formularios = this.formularioRepository.findByCodigoStartingWith(query);
		return formularios;
	}

}
