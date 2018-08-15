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

import br.edu.infnet.model.Modulo;
import br.edu.infnet.repository.ModuloRepository;

@Controller
@RequestMapping("/modulo")
public class ModuloController {

	@Autowired
	private ModuloRepository moduloRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("moduloMain");
		mav.addObject(new Modulo());
		mav.addObject("modulos", this.moduloRepository.findAll());
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("moduloMain");
		mav.addObject("modulo", this.moduloRepository.findById(id));
		mav.addObject("modulos", this.moduloRepository.findAll());
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.moduloRepository.deleteById(id);
		return "redirect:/modulo";
	}
	
	@PostMapping
	public String salvar(Modulo modulo) {
		this.moduloRepository.save(modulo);
		return "redirect:/modulo";
	}
	
	@ResponseBody
	@GetMapping("/list/getByNameStartingWith")
	public List<Modulo> findIdAsValueAndNomeAsDataByNomeStartingWith(@RequestParam("query") String query){
		List<Modulo> modulos = new ArrayList<>();
		modulos = this.moduloRepository.findByNomeStartingWith(query);
		return modulos;
	}
	
}
