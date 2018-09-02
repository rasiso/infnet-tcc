package br.edu.infnet.batch.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.edu.infnet.email.envio.EmailSenderService;
import br.edu.infnet.model.Avaliacao;
import br.edu.infnet.model.Mensagem;
import br.edu.infnet.model.ModeloAvaliacao;
import br.edu.infnet.repository.AvaliacaoRepository;

/**
 * Responsável por trabalhar as regras de negócio antes de enviar o email.
 */
@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);
    
    @Autowired
	private EmailSenderService emailSender;
    
    @Autowired
    private AvaliacaoRepository repositorio;

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
    	
    	List<Avaliacao> avaliacoesPendentes = obterAvaliacoesPendentes();
    	boolean existeAvaliacaoPendente = avaliacoesPendentes != null && !avaliacoesPendentes.isEmpty();
    	boolean convideNaoFoiEnviado;
    	Mensagem mensagem = null;
    	
    	if(existeAvaliacaoPendente) {
    		for(Avaliacao avaliacaoPendente : avaliacoesPendentes) {
        		convideNaoFoiEnviado = !avaliacaoPendente.getConviteEnviado();
        		
        		if(convideNaoFoiEnviado) {
        			mensagem = construirMensagem(avaliacaoPendente);
        			emailSender.enviar(mensagem);
        			registrarEnvio(avaliacaoPendente);
        			log.info("Email enviado com Sucesso para "+avaliacaoPendente.getRespondente().getEmail());
        		}
        	}
    	}
    	
    	
    	
        
    }

	

	private void registrarEnvio(Avaliacao avaliacaoPendente) {
		avaliacaoPendente.setConviteEnviado(true);		
		repositorio.saveAndFlush(avaliacaoPendente);
	}



	private Mensagem construirMensagem(Avaliacao avaliacaoPendente) {
		String remetente = "infnet.tcc@gmail.com";
		
		List<String> destinatarios = new ArrayList<String>();
		destinatarios.add(avaliacaoPendente.getRespondente().getEmail());
		
		String assunto = avaliacaoPendente.getModelo().getAssuntoEmail();
		String corpo = construirCorpoDaMensagem(avaliacaoPendente.getModelo());
		
		return new Mensagem(remetente, destinatarios, assunto, corpo);
	}

	



	private String construirCorpoDaMensagem(ModeloAvaliacao modelo) {		
		return modelo.getMensagemEmail();
	}



	private List<Avaliacao> obterAvaliacoesPendentes() {
		List<Avaliacao> avaliacoesPendentes = repositorio.obterAvaliacoesPendentes(new Date());
		System.out.println(avaliacoesPendentes.toString());
		return avaliacoesPendentes;
	}

	

}
