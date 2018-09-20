package br.edu.infnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Formulario;


@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long>{
	

}
