package br.edu.infnet.enumerations;

public enum Sexo {
	Masculino("Masculino"),
    Feminino("Feminino");
	
	
    private String valor;
    
    
    private Sexo(String valor) {
        this.valor = valor;
    }
    
    public String toString() {
        return valor;
    }
    
 
}
