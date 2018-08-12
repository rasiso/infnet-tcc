package br.edu.infnet.service;

import br.edu.infnet.model.Usuario;

public interface UsuarioService {
	public Usuario findUserByEmail(String email);
	public void saveUser(Usuario user);
}
