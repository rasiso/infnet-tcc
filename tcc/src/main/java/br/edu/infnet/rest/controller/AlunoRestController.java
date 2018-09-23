package br.edu.infnet.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.rest.to.RespostaAlunoService;
import br.edu.infnet.rest.to.RespostaAlunoTO;


@RestController()
public class AlunoRestController {
	
	
	
	@Autowired
	private RespostaAlunoService respostaAlunoService;
	
	
	@RequestMapping(value="/rest/aluno/{matricula}/avaliacao/{codigo}/respostas/", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<RespostaAlunoTO> respostaDoAluno(@PathVariable("matricula") String matricula, @PathVariable("codigo")String codigo) {
		
		RespostaAlunoTO respostaAluno = respostaAlunoService.obterRespostasDoAluno(matricula,codigo);
		
		if(respostaAluno == null) {
			return new ResponseEntity<RespostaAlunoTO>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<RespostaAlunoTO>(respostaAluno, HttpStatus.OK);
	}
	

}
