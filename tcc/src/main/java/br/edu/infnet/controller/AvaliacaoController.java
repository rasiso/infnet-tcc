package br.edu.infnet.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.model.Avaliacao;
import br.edu.infnet.model.ModeloAvaliacao;
import br.edu.infnet.model.Turma;
import br.edu.infnet.repository.AvaliacaoRepository;
import br.edu.infnet.service.FormularioService;

@Controller
@RequestMapping("/avaliacao")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private FormularioService formularioService;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("avaliacaoMain");
		Turma turma = new Turma();
		ModeloAvaliacao modeloAvaliacao = new ModeloAvaliacao();
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setModelo(modeloAvaliacao);
		avaliacao.setTurma(turma);
		mav.addObject("avaliacaoTemp", avaliacao);
		mav.addObject(new Avaliacao());
		mav.addObject("avaliacoes", this.avaliacaoRepository.findAll());
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("avaliacaoMain");
		Optional<Avaliacao> avaliacao = this.avaliacaoRepository.findById(id);
		avaliacao.ifPresent(obj -> mav.addObject("avaliacaoTemp", obj));
		mav.addObject("avaliacao", this.avaliacaoRepository.findById(id));
		mav.addObject("avaliacoes", this.avaliacaoRepository.findAll());
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.avaliacaoRepository.deleteById(id);
		return "redirect:/avaliacao";
	}
	
	@PostMapping
	public String salvar(Avaliacao avaliacao) {
		this.avaliacaoRepository.save(avaliacao);
		formularioService.criarFormularios(avaliacao);
		return "redirect:/avaliacao";
	}

}
