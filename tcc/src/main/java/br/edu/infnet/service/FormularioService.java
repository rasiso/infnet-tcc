package br.edu.infnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.model.Aluno;
import br.edu.infnet.model.Avaliacao;
import br.edu.infnet.model.Formulario;
import br.edu.infnet.model.Turma;
import br.edu.infnet.repository.FormularioRepository;
import br.edu.infnet.repository.TurmaRepository;

@Service
public class FormularioService {

	@Autowired
	private FormularioRepository formularioRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	
	public void criarFormularios(Avaliacao avaliacao) {
		
		Turma turma = turmaRepository.getOne(avaliacao.getTurma().getId());
		
		avaliacao.setTurma(turma);
		
		boolean existeAlunoNaTurma = turma.getAlunos() != null && !turma.getAlunos().isEmpty();
		
		if(existeAlunoNaTurma) {
			criaFormularioParaOsAlunosDaTurma(avaliacao);
		}
		
		
		
	}


	private void criaFormularioParaOsAlunosDaTurma(Avaliacao avaliacao) {
		List<Aluno> alunos = avaliacao.getTurma().getAlunos();
		
		boolean naoEncontrouFormularioParaAluno;
		
		Long avaliacaoId = avaliacao.getId();
		
		for(Aluno aluno : alunos) {
			naoEncontrouFormularioParaAluno = formularioRepository.obterRespondenteComAvaliacao(avaliacaoId, aluno.getId()) == null;
			
			if(naoEncontrouFormularioParaAluno) {
				Formulario formulario = new Formulario();
				formulario.setAvaliacao(avaliacao);
				formulario.setConviteEnviado(false);
				formulario.setRespondido(false);
				formulario.setRespondente(aluno);
				formularioRepository.saveAndFlush(formulario);
			}
		}
		
	}

	
	
}
