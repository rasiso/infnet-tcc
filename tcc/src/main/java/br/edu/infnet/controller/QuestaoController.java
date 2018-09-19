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

import br.edu.infnet.model.CategoriaQuestao;
import br.edu.infnet.model.Questao;
import br.edu.infnet.model.Turma;
import br.edu.infnet.repository.QuestaoRepository;

@Controller
@RequestMapping("/questao")
public class QuestaoController {

	@Autowired
	private QuestaoRepository questaoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("questaoMain");
		CategoriaQuestao categoria = new CategoriaQuestao();
		Questao questao = new Questao();
		questao.setCategoria(categoria);
		mav.addObject("questaoTemp", questao);
		mav.addObject(new Questao());
		mav.addObject("questoes", this.questaoRepository.findAll());
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("questaoMain");
		Optional<Questao> questao = this.questaoRepository.findById(id);
		questao.ifPresent(obj -> mav.addObject("questaoTemp", obj));
		mav.addObject("questao", this.questaoRepository.findById(id));
		mav.addObject("questoes", this.questaoRepository.findAll());
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.questaoRepository.deleteById(id);
		return "redirect:/questao";
	}
	
	@PostMapping
	public String salvar(Questao questao) {
		this.questaoRepository.save(questao);
		return "redirect:/questao";
	}
	
	@ResponseBody
	@GetMapping("/list/getByEnunciadoLike")
	public List<Questao> findByEnunciadoLike(@RequestParam("query") String query){
		List<Questao> questoes = new ArrayList<>();
		questoes = this.questaoRepository.findByEnunciadoContains(query);
		return questoes;
	}

}
