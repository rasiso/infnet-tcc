package br.edu.infnet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.model.User;
import br.edu.infnet.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User Usuario = new User();
		modelAndView.addObject("Usuario", Usuario);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.Usuario", "Já existe um usuário cadastrado no email fornecido");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registro");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "Usuario registrado com sucesso");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		System.out.println(user.getPassword());
		modelAndView.addObject("UsuarioName", "Benvindo " + user.getName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Conteudo somente para usuarios do grupo admin");
		modelAndView.setViewName("main");
		return modelAndView;
	}

	/*
	 * @RequestMapping(value="/main", method = RequestMethod.GET) public
	 * ModelAndView listar() {
	 * 
	 * ModelAndView mav = new ModelAndView("main"); //mav.addObject("main",
	 * this.cursoRepository.findAll()).addObject(new Curso()); return mav;
	 * 
	 * }
	 */

	@RequestMapping(value = "/turma**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("turma");

		return model;

	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();
		// checa se ususuario esta logado
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			//User userDetail = (User) auth.getPrincipal();
			
			Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
			String username = loggedInUser.getName();
			
			
			System.out.println(username);
			model.addObject("username", username);

		}

		model.setViewName("403");
		return model;

	}

}
