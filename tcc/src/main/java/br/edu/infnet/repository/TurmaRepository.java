package br.edu.infnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{
	

}
