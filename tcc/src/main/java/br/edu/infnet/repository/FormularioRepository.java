package br.edu.infnet.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.model.Formulario;


@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long>{

	
		
	@Query("SELECT f FROM Formulario f "
			+ "JOIN FETCH Avaliacao a on f.avaliacao.id = a.id"
			+ " WHERE a.inicio <= :hoje AND f.conviteEnviado = false")
	List<Formulario> obterFormulariosPendentes(@Param("hoje") Date hoje);
	
	
	@Query("SELECT f FROM Formulario f "
			+ "WHERE f.respondente.id = :alunoId AND f.avaliacao.id = :avaliacaoId")
	Formulario obterRespondenteComAvaliacao(@Param("avaliacaoId") Long avaliacaoId, @Param("alunoId") Long alunoId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Formulario f "
			+ "SET f.respondido = 1 WHERE f.id = :formularioId")
	void marcarComoRespondido(@Param("formularioId") Long formularioId);
	
}
