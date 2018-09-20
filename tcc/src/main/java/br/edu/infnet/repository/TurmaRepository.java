package br.edu.infnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
	public static final String FIND_ID_CODIGO = "SELECT TRM.* FROM TURMA TRM WHERE TRM.CODIGO LIKE %:codigo%";
	
	public List<Turma> findByCodigoStartingWith(String nome);
	
	@Query(value = FIND_ID_CODIGO, nativeQuery = true)
	public List<Turma> findIdAndCodigoByCodigoStartingWith(@Param("codigo") String codigo);
	
}
