package br.edu.infnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.ModeloAvaliacao;

@Repository
public interface ModeloAvaliacaoRepository extends JpaRepository<ModeloAvaliacao, Long>{
	
	public List<ModeloAvaliacao> findByCodigoStartingWith(String nome);

}
