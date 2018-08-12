package br.edu.infnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Usuario;


@Repository("userRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	 Usuario findByEmail(String email);
}
