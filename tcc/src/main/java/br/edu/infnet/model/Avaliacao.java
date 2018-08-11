package br.edu.infnet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = -3877906099521294116L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_aluno")
	private Aluno respondente;
	
	@ManyToOne
	@JoinColumn(name = "id_modelo")
	private ModeloAvaliacao modelo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date termino;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_turma")
	private Turma turma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getRespondente() {
		return respondente;
	}

	public void setRespondente(Aluno respondente) {
		this.respondente = respondente;
	}

	public ModeloAvaliacao getModelo() {
		return modelo;
	}

	public void setModelo(ModeloAvaliacao modelo) {
		this.modelo = modelo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((respondente == null) ? 0 : respondente.hashCode());
		result = prime * result + ((termino == null) ? 0 : termino.hashCode());
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
		Avaliacao other = (Avaliacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (respondente == null) {
			if (other.respondente != null)
				return false;
		} else if (!respondente.equals(other.respondente))
			return false;
		if (termino == null) {
			if (other.termino != null)
				return false;
		} else if (!termino.equals(other.termino))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}

	
}