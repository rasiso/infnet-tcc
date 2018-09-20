package br.edu.infnet.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Formulario;


@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long>{

	
		
	@Query("SELECT f FROM Formulario f "
			+ "JOIN FETCH Avaliacao a on f.avaliacao.id = a.id"
			+ " WHERE a.inicio <= :hoje AND f.conviteEnviado = false")
	List<Formulario> obterFormulariosPendentes(@Param("hoje") Date hoje);
	

}
