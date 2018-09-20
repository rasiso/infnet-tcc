package br.edu.infnet.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Avaliacao;
import br.edu.infnet.model.Formulario;


@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
	
	

}
