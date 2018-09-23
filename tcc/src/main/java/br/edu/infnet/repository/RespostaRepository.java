package br.edu.infnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.infnet.model.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long>{

	@Query("SELECT r FROM Resposta r "
			+ "JOIN FETCH Formulario f on r.formulario.id = f.id "			
			+ "JOIN FETCH Aluno al on r.aluno.id = al.id "
			+ "WHERE al.matricula = :matricula AND f.avaliacao.codigo = :codigo")
	List<Resposta> obterRespostasDoAlunoSobreAvaliacao(@Param("matricula") String matricula,@Param("codigo") String codigo);
	
	
	
	
}
