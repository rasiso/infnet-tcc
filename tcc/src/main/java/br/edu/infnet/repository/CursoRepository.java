package br.edu.infnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
	
	public Curso findByNome(String nome);

}
