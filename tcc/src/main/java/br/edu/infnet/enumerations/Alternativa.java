package br.edu.infnet.enumerations;

public enum Alternativa {
	
	DISCORDO_TOTALMENTE("Discordo totalmente"), 
	DISCORDO_PARCIALMENTE("Discordo parcialmente"), 
	INDIFERENTE("Indiferente"), 
	CONCORDO_PARCIALMENTE("Concordo parcialmente"), 
	CONCORDO_TOTALMENTE("Concordo totalmente"), 
	NAO_SOU_CAPAZ_DE_OPINAR("Não sou capaz de opinar");

	private String alternativa;
	
	private Alternativa(String alternativa) {
		this.alternativa = alternativa;
	}

	public String getAlternativa() {
		return alternativa;
	}
}
	
	
	
	

