package br.edu.infnet.converters;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.edu.infnet.enumerations.Sexo;
import br.edu.infnet.model.Formulario;


public class TagConverter {
	
		
	public String obterTexto(Formulario formulario, String texto) {
		
		String resultado = texto.replaceAll("<modulo>", formulario.getAvaliacao().getTurma().getModulo().getNome());
		String nome = formulario.getRespondente().getNome();
		resultado = resultado.replaceAll("<aluno>", nome.substring(0, nome.indexOf(" ")));
		resultado = resultado.replaceAll("<turma>", formulario.getAvaliacao().getTurma().getNome());
		resultado = tratarGenero(formulario, resultado);
		resultado = resultado.replaceAll("<link>", "localhost:9090/localizar/avaliacao/"+
											formulario.getAvaliacao().getId() + 
											"/formulario/"+formulario.getId());
		
		return resultado;
	}

	private String tratarGenero(Formulario formulario, String resultado) {
		int ocorrencias = resultado.split("<./.>").length-1;
		ocorrencias = (ocorrencias > 0) ? ocorrencias : 0;
		
		String tag;
		String prevalencia;
		Matcher m = Pattern.compile("<./.>").matcher(resultado);
		Sexo sexo = formulario.getRespondente().getSexo();
		while(m.find()) {
			tag = resultado.substring(m.start(), m.end());
			
			if(sexo.equals(Sexo.Feminino)) {
				prevalencia = tag.substring(tag.indexOf("/")+1,tag.indexOf(">"));
			} else {
				prevalencia = tag.substring(tag.indexOf("<")+1,tag.indexOf("/"));
			}
			
			resultado = resultado.replaceFirst("<./.>",prevalencia);
		}
				
		return resultado;
	}

}
