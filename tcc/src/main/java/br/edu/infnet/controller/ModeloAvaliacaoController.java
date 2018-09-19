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

import br.edu.infnet.model.ModeloAvaliacao;
import br.edu.infnet.repository.ModeloAvaliacaoRepository;

@Controller
@RequestMapping("/modeloAvaliacao")
public class ModeloAvaliacaoController {

	@Autowired
	private ModeloAvaliacaoRepository modeloAvaliacaoRepository;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("modeloAvaliacaoMain");
		mav.addObject(new ModeloAvaliacao());
		mav.addObject("modeloAvaliacaoTemp", new ModeloAvaliacao());
		mav.addObject("modelosAvaliacao", this.modeloAvaliacaoRepository.findAll());
		return mav;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("modeloAvaliacaoMain");
		Optional<ModeloAvaliacao> modeloAvaliacao = this.modeloAvaliacaoRepository.findById(id);
		modeloAvaliacao.ifPresent(obj -> mav.addObject("modeloAvaliacaoTemp", obj));
		mav.addObject("modeloAvaliacao", modeloAvaliacao);
		mav.addObject("modelosAvaliacao", this.modeloAvaliacaoRepository.findAll());
		return mav;
	}

	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.modeloAvaliacaoRepository.deleteById(id);
		return "redirect:/modeloAvaliacao";
	}

	@PostMapping
	public String salvar(ModeloAvaliacao modeloAvaliacao) {
		this.modeloAvaliacaoRepository.save(modeloAvaliacao);
		return "redirect:/modeloAvaliacao";
	}
	
	@ResponseBody
	@GetMapping("/list/getByNameStartingWith")
	public List<ModeloAvaliacao> findIdAsValueAndNomeAsDataByNomeStartingWith(@RequestParam("query") String query){
		List<ModeloAvaliacao> modelos = new ArrayList<>();
		modelos = this.modeloAvaliacaoRepository.findByCodigoStartingWith(query);
		return modelos;
	}

}
