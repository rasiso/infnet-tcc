package br.edu.infnet.batch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.email.envio.EmailSenderService;
import br.edu.infnet.model.Avaliacao;
import br.edu.infnet.model.Mensagem;

@Service
public class EmailCoordenadorService {
	
	@Autowired
	private EmailSenderService emailSender;
	

	public void enviarEmail(Avaliacao avaliacao) {
		emailSender.enviar(construirMensagem(avaliacao));
	}
	
	
	
	private Mensagem construirMensagem(Avaliacao avaliacao) {
		String remetente = "infnet.tcc@gmail.com";
		String assunto = ""; 
		String corpo = ""; 
		
		List<String> destinatarios = new ArrayList<String>();
			
		destinatarios.add("coordenador@infnet.com.br");
		assunto = "Atualização dos Formulários Respondidos para a Avalicação "+avaliacao.getCodigo();
		corpo = "Olá, Coordenador. \nPara verificar as novas respostas clique no link:\n "
				+ "http://localhost:9090/rest/avaliacao/"+avaliacao.getCodigo()+"/respostas/";			
			
		return new Mensagem(remetente, destinatarios, assunto, corpo);	
	}
	
	
}
