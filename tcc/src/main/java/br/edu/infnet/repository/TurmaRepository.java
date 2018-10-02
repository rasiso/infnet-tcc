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
	
	public static final String ENCONTRE_TURMA_PELO_CODIGO_DA_AVALIACAO = 		"SELECT t FROM Turma t "
											+ "JOIN FETCH Avaliacao a on a.turma.id = t.id "
											+ "WHERE a.codigo = :codigoAvaliacao";
			
	
	public List<Turma> findByCodigoStartingWith(String nome);
	
	@Query(value = FIND_ID_CODIGO, nativeQuery = true)
	public List<Turma> findIdAndCodigoByCodigoStartingWith(@Param("codigo") String codigo);

	@Query(value = ENCONTRE_TURMA_PELO_CODIGO_DA_AVALIACAO)
	public Turma obterTurmaViaCodigoDaAvaliacao(@Param("codigoAvaliacao") String codigoAvaliacao);
	
}
