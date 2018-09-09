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

import br.edu.infnet.model.CategoriaQuestao;
import br.edu.infnet.repository.CategoriaQuestaoRepository;

@Controller
@RequestMapping("/categoriaQuestao")
public class CategoriaQuestaoController {

	@Autowired
	private CategoriaQuestaoRepository categoriaQuestaoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("categoriaQuestaoMain");
		mav.addObject(new CategoriaQuestao());
		mav.addObject("categoriaQuestoes", this.categoriaQuestaoRepository.findAll());
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("categoriaQuestaoMain");
		mav.addObject("categoriaQuestao", this.categoriaQuestaoRepository.findById(id));
		mav.addObject("categoriaQuestoes", this.categoriaQuestaoRepository.findAll());
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.categoriaQuestaoRepository.deleteById(id);
		return "redirect:/categoriaQuestao";
	}
	
	@PostMapping
	public String salvar(CategoriaQuestao categoriaQuestao) {
		this.categoriaQuestaoRepository.save(categoriaQuestao);
		return "redirect:/categoriaQuestao";
	}
	
	@ResponseBody
	@GetMapping("/list/getByNameStartingWith")
	public List<CategoriaQuestao> findIdAsValueAndNomeAsDataByNomeStartingWith(@RequestParam("query") String query){
		List<CategoriaQuestao> categoriaQuestoes = new ArrayList<>();
		categoriaQuestoes = this.categoriaQuestaoRepository.findByNomeStartingWith(query);
		return categoriaQuestoes;
	}

}
