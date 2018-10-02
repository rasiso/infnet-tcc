package br.edu.infnet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.model.Aluno;
import br.edu.infnet.model.Resposta;
import br.edu.infnet.model.Turma;
import br.edu.infnet.repository.RespostaRepository;
import br.edu.infnet.repository.TurmaRepository;
import br.edu.infnet.rest.to.RespostasDaTurmaTO;

@Service
public class RespostasDaTurmaService {
			
	@Autowired
	private RespostaRepository respostaRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public RespostasDaTurmaTO obterRespostasDaTurma(String codigo) {
		
		Turma turma = turmaRepository.obterTurmaViaCodigoDaAvaliacao(codigo);
		
		List<List<Resposta>> respostas = new ArrayList<List<Resposta>>();
		for(Aluno aluno : turma.getAlunos()) {
			respostas.add(respostaRepository.obterRespostasDoAlunoSobreAvaliacao(aluno.getMatricula(), codigo));
		}
		
		RespostasDaTurmaTO respostasDaTurma = new RespostasDaTurmaTO();
		respostasDaTurma.setTurma(turma);
		respostasDaTurma.setRespostas(respostas);
		
		return respostasDaTurma;
	}
	
}
