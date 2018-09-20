package br.edu.infnet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Formulario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_avaliacao")
	private Avaliacao avaliacao;
	
	@OneToOne	
	@JoinColumn(name = "id_aluno")
	private Aluno respondente;
	
	@Column(name="convite_enviado")
	private Boolean conviteEnviado;
	
	@Column(name="respondido")
	private Boolean respondido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Aluno getRespondente() {
		return respondente;
	}

	public void setRespondente(Aluno respondente) {
		this.respondente = respondente;
	}

	public Boolean getConviteEnviado() {
		return conviteEnviado;
	}

	public void setConviteEnviado(Boolean conviteEnviado) {
		this.conviteEnviado = conviteEnviado;
	}

	public Boolean getRespondido() {
		return respondido;
	}

	public void setRespondido(Boolean respondido) {
		this.respondido = respondido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avaliacao == null) ? 0 : avaliacao.hashCode());
		result = prime * result + ((conviteEnviado == null) ? 0 : conviteEnviado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((respondente == null) ? 0 : respondente.hashCode());
		result = prime * result + ((respondido == null) ? 0 : respondido.hashCode());
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
		Formulario other = (Formulario) obj;
		if (avaliacao == null) {
			if (other.avaliacao != null)
				return false;
		} else if (!avaliacao.equals(other.avaliacao))
			return false;
		if (conviteEnviado == null) {
			if (other.conviteEnviado != null)
				return false;
		} else if (!conviteEnviado.equals(other.conviteEnviado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (respondente == null) {
			if (other.respondente != null)
				return false;
		} else if (!respondente.equals(other.respondente))
			return false;
		if (respondido == null) {
			if (other.respondido != null)
				return false;
		} else if (!respondido.equals(other.respondido))
			return false;
		return true;
	}
	
}
