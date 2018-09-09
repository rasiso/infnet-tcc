package br.edu.infnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.CategoriaQuestao;

@Repository
public interface CategoriaQuestaoRepository extends JpaRepository<CategoriaQuestao, Long>{
	
	public List<CategoriaQuestao> findByNomeStartingWith(String nome);
}
