package br.edu.infnet.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.batch.service.EmailCoordenadorService;
import br.edu.infnet.batch.service.EmailService;
import br.edu.infnet.model.Formulario;
import br.edu.infnet.model.Questao;
import br.edu.infnet.model.Resposta;
import br.edu.infnet.repository.AvaliacaoRepository;
import br.edu.infnet.repository.FormularioRepository;
import br.edu.infnet.repository.RespostaRepository;

@Controller
@RequestMapping("/resposta")
public class RespostaController {

	@Autowired
	private RespostaRepository respostaRepository;
	@Autowired
	private FormularioRepository formularioRepository;
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private EmailCoordenadorService emailService;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("respostaMain");
		Resposta resposta = new Resposta();
		mav.addObject("respostaTemp", resposta);
		mav.addObject(new Resposta());
		mav.addObject("questoes", this.respostaRepository.findAll());
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("respostaMain");
		Optional<Resposta> resposta = this.respostaRepository.findById(id);
		resposta.ifPresent(obj -> mav.addObject("respostaTemp", obj));
		mav.addObject("resposta", this.respostaRepository.findById(id));
		mav.addObject("questoes", this.respostaRepository.findAll());
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable long id) {
		this.respostaRepository.deleteById(id);
		return "redirect:/resposta";
	}
	
	@PostMapping
	public void salvar(Formulario formulario, HttpServletResponse response) throws IOException {
		Resposta resposta;
		Questao questaoTemp;
		Formulario formularioTemp;
		for(Questao questao : formulario.getAvaliacao().getModelo().getQuestoes()) {
			resposta = new Resposta();
			questaoTemp = new Questao();
			formularioTemp = new Formulario();
			
			resposta.setQuestao(questaoTemp);
			resposta.setFormulario(formularioTemp);
			
			resposta.getQuestao().setId(questao.getId());
			resposta.setValor(questao.getResposta().getValor());
			resposta.getFormulario().setId(formulario.getId());
			this.respostaRepository.save(resposta);
		}
		this.formularioRepository.marcarComoRespondido(formulario.getId());
		formulario.setAvaliacao(avaliacaoRepository.obterAvaliacaoViaFormulario(formulario.getId()));
		emailService.enviarEmail(formulario.getAvaliacao());
		//return "redirect:/formulario/"+formulario.getId();
		response.sendRedirect("/formulario/"+formulario.getId());
	}
	
}
