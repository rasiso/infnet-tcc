package br.edu.infnet.rest.to;

import java.util.List;

import br.edu.infnet.model.Resposta;
import br.edu.infnet.model.Turma;

public class RespostasDaTurmaTO {
	
	private Turma turma;
	private List<List<Resposta>> respostas;
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public List<List<Resposta>> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<List<Resposta>> respostas) {
		this.respostas = respostas;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((respostas == null) ? 0 : respostas.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespostasDaTurmaTO other = (RespostasDaTurmaTO) obj;
		if (respostas == null) {
			if (other.respostas != null)
				return false;
		} else if (!respostas.equals(other.respostas))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}
	
	
	
	

}
