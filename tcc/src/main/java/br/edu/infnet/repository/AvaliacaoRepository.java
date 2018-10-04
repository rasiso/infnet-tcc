package br.edu.infnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Avaliacao;


@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
	
	@Query("SELECT a FROM Avaliacao a "
			+ "JOIN FETCH Formulario f on a.id = f.avaliacao.id "			
			+ "WHERE f.id = :formularioid")
	public Avaliacao obterAvaliacaoViaFormulario(@Param("formularioid") Long formularioid);

}
