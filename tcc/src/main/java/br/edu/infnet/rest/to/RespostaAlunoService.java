package br.edu.infnet.rest.to;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.model.Aluno;
import br.edu.infnet.model.Resposta;
import br.edu.infnet.repository.AlunoRepository;
import br.edu.infnet.repository.RespostaRepository;

@Service
public class RespostaAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private RespostaRepository respostaRepository;
	
	public RespostaAlunoTO obterRespostasDoAluno(String matricula, String codigo) {
		RespostaAlunoTO respostaAlunoTO = new RespostaAlunoTO();
		
		Aluno aluno = alunoRepository.findByMatricula(matricula);
		List<Resposta> respostas = respostaRepository.obterRespostasDoAlunoSobreAvaliacao(matricula, codigo);
		
		respostaAlunoTO.setAluno(aluno);
		respostaAlunoTO.setRespostas(respostas);
		
		return respostaAlunoTO;
	}
	
	
	
	

	
	
}
