package br.edu.infnet.service;


import org.springframework.stereotype.Service;
import br.edu.infnet.model.User;

 
public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}