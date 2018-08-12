package br.edu.infnet.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.infnet.model.Role;
import br.edu.infnet.model.Usuario;
import br.edu.infnet.repository.RoleRepository;
import br.edu.infnet.repository.UsuarioRepository;



@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Usuario findUserByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public void saveUser(Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuario.setActive(1);
        Role usuarioRole = roleRepository.findByRole("ADMIN");
        usuario.setRoles(new HashSet<Role>(Arrays.asList(usuarioRole)));
		usuarioRepository.save(usuario);
	}

}
