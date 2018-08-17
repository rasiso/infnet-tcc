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

import br.edu.infnet.model.Usuario;
import br.edu.infnet.service.UsuarioService;


@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService  usuarioServiceImpl;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		Usuario Usuario = new Usuario();
		modelAndView.addObject("Usuario", Usuario);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUsuario(@Valid Usuario usuario, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Usuario UsuarioExists = usuarioServiceImpl.findUserByEmail(usuario.getEmail());
		if (UsuarioExists != null) {
			bindingResult
					.rejectValue("email", "error.Usuario",
							"Já existe um usuário cadastrado no email fornecido");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registro");
		} else {
			usuarioServiceImpl.saveUser(usuario);
			modelAndView.addObject("successMessage", "Usuario registrado com sucesso");
			modelAndView.addObject("Usuario", new Usuario());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = usuarioServiceImpl.findUserByEmail(auth.getName());
		System.out.println(usuario.getPassword());
		modelAndView.addObject("UsuarioName", "Benvindo " + usuario.getNome() + " (" + usuario.getEmail() + ")");
		modelAndView.addObject("adminMessage","Conteudo somente para usuarios do grupo admin");
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	/*@RequestMapping(value="/main", method = RequestMethod.GET)
	public ModelAndView listar() {
		
		ModelAndView mav = new ModelAndView("main");
		//mav.addObject("main", this.cursoRepository.findAll()).addObject(new Curso());
		return mav;
	
	}*/
	
	@RequestMapping(value = "/turma**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("turma");

		return model;

	}
	
	
	
	//for 403 access denied page
		@RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied() {

			ModelAndView model = new ModelAndView();
			
			//checa se ususuario esta  logado
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken)) {
				Usuario userDetail = (Usuario) auth.getPrincipal();
				System.out.println(userDetail);
			
				model.addObject("username", userDetail.getNome());
				
			}
			
			model.setViewName("403");
			return model;

		}


}
