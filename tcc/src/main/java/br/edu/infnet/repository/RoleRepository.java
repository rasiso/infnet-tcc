package br.edu.infnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>{
	public Role findByRole(String descricao);

}
