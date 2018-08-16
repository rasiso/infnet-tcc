package br.edu.infnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long>{
	
	public List<Modulo> findByNomeStartingWith(String nome);

}
