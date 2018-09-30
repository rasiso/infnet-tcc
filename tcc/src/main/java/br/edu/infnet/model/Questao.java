package br.edu.infnet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Questao implements Serializable {

	private static final long serialVersionUID = 8843242245478530980L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	private String enunciado;

	@JsonIgnore
	@ManyToMany(mappedBy = "questoes")
	private List<ModeloAvaliacao> modelosAvaliacoes;
	
	@ManyToOne
    @JoinColumn(name = "categoria_id")
	private CategoriaQuestao categoria;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "resposta_id")
	private Resposta resposta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<ModeloAvaliacao> getModelosAvaliacoes() {
		return modelosAvaliacoes;
	}

	public void setModelosAvaliacoes(List<ModeloAvaliacao> modelosAvaliacoes) {
		this.modelosAvaliacoes = modelosAvaliacoes;
	}

	public CategoriaQuestao getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaQuestao categoria) {
		this.categoria = categoria;
	}

	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((enunciado == null) ? 0 : enunciado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelosAvaliacoes == null) ? 0 : modelosAvaliacoes.hashCode());
		result = prime * result + ((resposta == null) ? 0 : resposta.hashCode());
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
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (enunciado == null) {
			if (other.enunciado != null)
				return false;
		} else if (!enunciado.equals(other.enunciado))
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
		if (resposta == null) {
			if (other.resposta != null)
				return false;
		} else if (!resposta.equals(other.resposta))
			return false;
		return true;
	}
	
}