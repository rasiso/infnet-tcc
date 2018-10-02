package br.edu.infnet.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rest.to.RespostasDaTurmaTO;
import br.edu.infnet.service.RespostasDaTurmaService;


@RestController()
public class RespostasRestController {
	
	
	
	@Autowired
	private RespostasDaTurmaService respostasDaTurmaService;
	
	
	@RequestMapping(value="/rest/avaliacao/{codigo}/respostas/", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<RespostasDaTurmaTO> respostaDoAluno(@PathVariable("codigo")String codigo) {
		
		RespostasDaTurmaTO respostaDaTurma = respostasDaTurmaService.obterRespostasDaTurma(codigo);
		
		if(respostaDaTurma == null) {
			return new ResponseEntity<RespostasDaTurmaTO>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<RespostasDaTurmaTO>(respostaDaTurma, HttpStatus.OK);
	}
	

}
