package br.edu.infnet.batch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Responsável por trabalhar as regras de negócio antes de enviar o email.
 */
@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

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
    	
        log.info("Prepado para enviar emails");
    }

	

}
