package br.edu.infnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Bloco;

@Repository
public interface BlocoRepository extends JpaRepository<Bloco, Long>{
	
	public List<Bloco> findByNomeStartingWith(String nome);
	
}
