package br.edu.infnet.batch.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.converters.TagConverter;
import br.edu.infnet.email.envio.EmailSenderService;
import br.edu.infnet.model.Avaliacao;
import br.edu.infnet.model.Formulario;
import br.edu.infnet.model.Mensagem;
import br.edu.infnet.repository.AvaliacaoRepository;
import br.edu.infnet.repository.FormularioRepository;

/**
 * Responsável por trabalhar as regras de negócio antes de enviar o email.
 */
@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);
    
    @Autowired
	private EmailSenderService emailSender;
    
    
    @Autowired
    private FormularioRepository formularioRepositorio;

    public void enviar() {
    	
    	/**
    	 * Algoritmo Executado de hora em Hora
    	 * 
    	 * 1 - Recuperar data e hora do início da avaliação em que a data é maior que o início e menor que o término e que o
    	 * 		convite ainda não foi enviado.
    	 * 
    	 * 2 - Disparar o envio do email.
    	 * 
    	 */
    	
    	    	
    	boolean convideNaoFoiEnviado;
    	Mensagem mensagem = null;
    	
    	List<Formulario> formulariosPendentes = obterFormulariosPendentes();
    	boolean existeFormularioPendente = formulariosPendentes != null && !formulariosPendentes.isEmpty();
    	
    	if(existeFormularioPendente) {
    		for(Formulario formularioPendente : formulariosPendentes) {
				convideNaoFoiEnviado = !formularioPendente.getConviteEnviado();
        		if(convideNaoFoiEnviado) {
        			mensagem = construirMensagem(formularioPendente);
        			emailSender.enviar(mensagem);
        			registrarEnvio(formularioPendente);
        			log.info("Email enviado com Sucesso para "+formularioPendente.getRespondente().getEmail());
        		}
    			
        	}
    	}
        
    }

	

	private List<Formulario> obterFormulariosPendentes() {
		List<Formulario> formulariosPendentes = null;
		try {
			formulariosPendentes = formularioRepositorio.obterFormulariosPendentes(new Date());
			System.out.println(formulariosPendentes.toString());
		} catch (Exception e) {
			System.err.println("Repositorio do Formulario nao esta disponivel."+e.getMessage());
			
		}
		
		return formulariosPendentes;
	}



	private void registrarEnvio(Formulario formularioPendente) {
		formularioPendente.setConviteEnviado(true);		
		formularioRepositorio.saveAndFlush(formularioPendente);
	}



	private Mensagem construirMensagem(Formulario formularioPendente) {
		String remetente = "infnet.tcc@gmail.com";
		String assunto = ""; 
		String corpo = ""; 
		
		List<String> destinatarios = new ArrayList<String>();
			
		destinatarios.add(formularioPendente.getRespondente().getEmail());
		assunto = obterAssuntoEmail(formularioPendente);
		corpo = construirCorpoDaMensagem(formularioPendente);			
			
		return new Mensagem(remetente, destinatarios, assunto, corpo);	
	}

	private String obterAssuntoEmail(Formulario formulario) {
		return new TagConverter().obterTexto(formulario, formulario.getAvaliacao().getModelo().getAssuntoEmail());
	}

	private String construirCorpoDaMensagem(Formulario formulario) {		
		return new TagConverter().obterTexto(formulario, formulario.getAvaliacao().getModelo().getMensagemEmail());
	}

	

}
