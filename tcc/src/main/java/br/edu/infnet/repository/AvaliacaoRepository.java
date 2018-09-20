package br.edu.infnet.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Avaliacao;


@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
	
	@Query("SELECT a FROM Avaliacao a "
			+ "INNER JOIN Formulario f on f.avaliacao.id = a.id"
			+ " WHERE a.inicio <= :hoje AND f.conviteEnviado = false")
	List<Avaliacao> obterAvaliacoesPendentes(@Param("hoje") Date inicio) ;

}
