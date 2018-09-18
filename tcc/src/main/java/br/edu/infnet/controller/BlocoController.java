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

import br.edu.infnet.model.Bloco;
import br.edu.infnet.model.Curso;
import br.edu.infnet.repository.BlocoRepository;

@Controller
@RequestMapping("/bloco")
public class BlocoController {

	@Autowired
	private BlocoRepository blocoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("blocoMain");
		/* rever esse ponto. Codigo feito para conseguir fazer funcionar o javascript do autocomplete 
		que tentava acessar o blocoTemp.curso.name e dava erro quando o objeto não existia		
		*/
		Curso curso = new Curso();
		Bloco bloco = new Bloco();
		bloco.setCurso(curso);
		mav.addObject("blocoTemp", bloco);
		mav.addObject(new Bloco());
		mav.addObject("blocos", this.blocoRepository.findAll());
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("blocoMain");
		Optional<Bloco> bloco = this.blocoRepository.findById(id);
		bloco.ifPresent(obj -> mav.addObject("blocoTemp", obj));
		mav.addObject("bloco", bloco);
		mav.addObject("blocos", this.blocoRepository.findAll());
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.blocoRepository.deleteById(id);
		return "redirect:/bloco";
	}
	
	@PostMapping
	public String salvar(Bloco bloco) {
		this.blocoRepository.save(bloco);
		return "redirect:/bloco";
	}

	@ResponseBody
	@GetMapping("/list/getByNameStartingWith")
	public List<Bloco> findIdAsValueAndNomeAsDataByNomeStartingWith(@RequestParam("query") String query){
		List<Bloco> blocos = new ArrayList<>();
		blocos = this.blocoRepository.findByNomeStartingWith(query);
		return blocos;
	}
}
