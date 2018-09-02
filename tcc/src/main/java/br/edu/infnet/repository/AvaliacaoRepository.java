package br.edu.infnet.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Avaliacao;


@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
	
	@Query("SELECT a FROM Avaliacao a WHERE a.inicio <= :hoje AND a.conviteEnviado = false")
	List<Avaliacao> obterAvaliacoesPendentes(Date hoje);

}
