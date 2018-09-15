package br.edu.infnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Questao;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long>{

	public List<Questao> findByEnunciadoContains(String enunciado);

}
