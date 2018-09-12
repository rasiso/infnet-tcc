package br.edu.infnet.converters;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


import br.edu.infnet.enumerations.Sexo;
import br.edu.infnet.model.Avaliacao;


public class TagConverter {
	
		
	public String obterTexto(Avaliacao avaliacao,String texto) {
		
		String resultado = texto.replaceAll("<modulo>", avaliacao.getTurma().getModulo().getNome());
		String nome = avaliacao.getRespondente().getNome();
		resultado = resultado.replaceAll("<aluno>", nome.substring(0, nome.indexOf(" ")));
		resultado = tratarGenero(avaliacao,resultado);
		resultado = resultado.replaceAll("<link>", "localhost:9090/localizar/avaliacao/"+avaliacao.getId());
		
		return resultado;
	}

	private String tratarGenero(Avaliacao avaliacao,String resultado) {
		int ocorrencias = resultado.split("<./.>").length-1;
		ocorrencias = (ocorrencias > 0) ? ocorrencias : 0;
		
		String tag;
		String prevalencia;
		Matcher m = Pattern.compile("<./.>").matcher(resultado);
		Sexo sexo = avaliacao.getRespondente().getSexo();
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
