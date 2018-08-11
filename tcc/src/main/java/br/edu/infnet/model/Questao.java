package br.edu.infnet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NaturalId;

@Entity
public class Questao implements Serializable {

	private static final long serialVersionUID = 8843242245478530980L;

	@Id
	@GeneratedValue
	private Long id;

	@NaturalId
	private String codigo;

	@Lob
	private String cabecalho;

	@ManyToMany(mappedBy = "questoes")
	private List<ModeloAvaliacao> modelosAvaliacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}

	public List<ModeloAvaliacao> getModelosAvaliacoes() {
		return modelosAvaliacoes;
	}

	public void setModelosAvaliacoes(List<ModeloAvaliacao> modelosAvaliacoes) {
		this.modelosAvaliacoes = modelosAvaliacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cabecalho == null) ? 0 : cabecalho.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelosAvaliacoes == null) ? 0 : modelosAvaliacoes.hashCode());
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
		Questao other = (Questao) obj;
		if (cabecalho == null) {
			if (other.cabecalho != null)
				return false;
		} else if (!cabecalho.equals(other.cabecalho))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modelosAvaliacoes == null) {
			if (other.modelosAvaliacoes != null)
				return false;
		} else if (!modelosAvaliacoes.equals(other.modelosAvaliacoes))
			return false;
		return true;
	}

}