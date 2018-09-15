package br.edu.infnet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MODELO_AVALIACAO")
public class ModeloAvaliacao implements Serializable {

	private static final long serialVersionUID = -3877906099521294116L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NaturalId
	private String codigo;

	@Lob
	private String objetivo;

	@Column(name = "assunto_email")
	private String assuntoEmail;

	@Lob
	@Column(name = "mensagem_email")
	private String mensagemEmail;

	@ManyToMany
	@JoinTable(name = "modelo_avaliacao_x_questao", joinColumns = {
			@JoinColumn(name = "id_modelo_avaliacao") }, inverseJoinColumns = { @JoinColumn(name = "id_questao") })
	private List<Questao> questoes;

	@JsonIgnore
	@OneToMany(mappedBy = "modelo")
	private List<Avaliacao> avaliacoes;

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

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getAssuntoEmail() {
		return assuntoEmail;
	}

	public void setAssuntoEmail(String assuntoEmail) {
		this.assuntoEmail = assuntoEmail;
	}

	public String getMensagemEmail() {
		return mensagemEmail;
	}

	public void setMensagemEmail(String mensagemEmail) {
		this.mensagemEmail = mensagemEmail;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assuntoEmail == null) ? 0 : assuntoEmail.hashCode());
		result = prime * result + ((avaliacoes == null) ? 0 : avaliacoes.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mensagemEmail == null) ? 0 : mensagemEmail.hashCode());
		result = prime * result + ((objetivo == null) ? 0 : objetivo.hashCode());
		result = prime * result + ((questoes == null) ? 0 : questoes.hashCode());
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
		ModeloAvaliacao other = (ModeloAvaliacao) obj;
		if (assuntoEmail == null) {
			if (other.assuntoEmail != null)
				return false;
		} else if (!assuntoEmail.equals(other.assuntoEmail))
			return false;
		if (avaliacoes == null) {
			if (other.avaliacoes != null)
				return false;
		} else if (!avaliacoes.equals(other.avaliacoes))
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
		if (mensagemEmail == null) {
			if (other.mensagemEmail != null)
				return false;
		} else if (!mensagemEmail.equals(other.mensagemEmail))
			return false;
		if (objetivo == null) {
			if (other.objetivo != null)
				return false;
		} else if (!objetivo.equals(other.objetivo))
			return false;
		if (questoes == null) {
			if (other.questoes != null)
				return false;
		} else if (!questoes.equals(other.questoes))
			return false;
		return true;
	}

}