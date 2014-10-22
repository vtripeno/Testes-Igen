package br.com.teste2.pagantes;

public enum PrecoPagantes {
	CRIANCA("CRIANÇA", 5.50), ESTUDANTE("ESTUDANTE", 8.00), IDOSO("IDOSO", 6.00);
	
	private String pagante;
	private double preco;
	
	PrecoPagantes(String pagante, double preco) {
		this.pagante = pagante;
		this.preco = preco;
	}
	
	public String getPagante() {
		return this.pagante;
	}
	
	public double getPreco() {
		return this.preco;
	}
}
