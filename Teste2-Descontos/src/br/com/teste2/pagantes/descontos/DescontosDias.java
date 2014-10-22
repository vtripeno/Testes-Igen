package br.com.teste2.pagantes.descontos;

import java.util.Calendar;
import java.util.Date;

import br.com.teste2.pagantes.PrecoPagantes;

public class DescontosDias {

	/**
	 * Método para verificar e exibir os descontos devido aos seus dias equivalentes
	 * @param hoje - data referente ao dia vigente
	 * @param flgCarteiraEstudante - verificar se carteira de estudante foi apresentada
	 * @param flgFeriado - verificar se é feriado
	 */
	public static String verificarDesconto(Date hoje, boolean flgCarteiraEstudante, boolean flgFeriado) {

		StringBuilder stb = new StringBuilder();
		
		stb.append(exibirPreco());
		Calendar cal = Calendar.getInstance();
		cal.setTime(hoje);
		
		int day = cal.get(Calendar.DAY_OF_WEEK);
		switch (day) {
			case Calendar.SUNDAY:
				
				stb.append("HOJE É DOMINGO\n")
					.append("\tDESCONTOS DO DIA\n")
					.append(PrecoPagantes.IDOSO.getPagante())
					.append(" Preço com 5% de desconto R$:")
					.append(String.format("%.2f", calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 5)))
					.append("\n")
					.append("Carteira de Estudante não é aceita aos finais de semana");
				break;
				
			case Calendar.MONDAY:
				
				stb.append("HOJE É SEGUNDA-FEIRA\n")
					.append("\tDESCONTOS DO DIA\n")
					.append(PrecoPagantes.CRIANCA.getPagante())
					.append(" Preço com 10% de desconto R$:")
					.append(String.format("%.2f", calcularDesconto(PrecoPagantes.CRIANCA.getPreco(), 10)))
					.append("\n");
				
				if(flgCarteiraEstudante) {
					stb.append(PrecoPagantes.ESTUDANTE.getPagante())
						.append(" Preço com 35% de desconto devido apresentação de carteirinha R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.ESTUDANTE.getPreco(), 35)))
						.append("\n");
				}	
				
				if(flgFeriado) {
					
					stb.append(PrecoPagantes.IDOSO.getPagante())
						.append(" Preço com 5% de desconto devido ao feriado R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 5)))
						.append("\n");
				}
				
				if(!flgCarteiraEstudante) {
					stb.append(PrecoPagantes.ESTUDANTE.getPagante())
						.append(" Preço com 10% de desconto R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.ESTUDANTE.getPreco(), 10)))
						.append("\n");
				} else {
					stb.append(PrecoPagantes.ESTUDANTE.getPagante())
						.append(" Preço com 35% de desconto devido apresentação de carteirinha R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.ESTUDANTE.getPreco(), 35)))
						.append("\n");
				}
				
				if(flgFeriado) {
					stb.append(PrecoPagantes.IDOSO.getPagante())
						.append(" Preço com 5% de desconto devido ao feriado R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 5)))
						.append("\n");
				} else {
					stb.append(PrecoPagantes.IDOSO.getPagante())
						.append(" Preço com 10% de desconto R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 10)));
				}
				
				break;
			case Calendar.TUESDAY:
				
				stb.append("HOJE É TERÇA-FEIRA\n")
					.append("\tDESCONTOS DO DIA\n")
					.append(PrecoPagantes.CRIANCA.getPagante())
					.append(" Preço com 15% de desconto R$:")
					.append(String.format("%.2f", calcularDesconto(PrecoPagantes.CRIANCA.getPreco(), 15)))
					.append("\n");
				
				if(!flgCarteiraEstudante) {
					stb.append(PrecoPagantes.ESTUDANTE.getPagante())
						.append(" Preço com 5% de desconto R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.ESTUDANTE.getPreco(), 5)))
						.append("\n");
				} else {
					stb.append(PrecoPagantes.ESTUDANTE.getPagante())
						.append(" Preço com 35% de desconto devido apresentação de carteirinha R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.ESTUDANTE.getPreco(), 35)))
						.append("\n");
				}
				
				if(flgFeriado) {
					stb.append(PrecoPagantes.IDOSO.getPagante())
						.append(" Preço com 5% de desconto devido ao feriado R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 5)))
						.append("\n");
				} else {
					stb.append(PrecoPagantes.IDOSO.getPagante())
						.append(" Preço com 15% de desconto R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 15)));
				}
				
				break;
			case Calendar.WEDNESDAY:
				
				stb.append("HOJE É QUARTA-FEIRA\n")
					.append("\tDESCONTOS DO DIA\n")
					.append(PrecoPagantes.CRIANCA.getPagante())
					.append(" Preço com 30% de desconto R$:")
					.append(String.format("%.2f", calcularDesconto(PrecoPagantes.CRIANCA.getPreco(), 30)))
					.append("\n")				
					.append(PrecoPagantes.ESTUDANTE.getPagante())
					.append(" Preço com 50% de desconto R$:")
					.append(String.format("%.2f", calcularDesconto(PrecoPagantes.ESTUDANTE.getPreco(), 50)))
					.append("\n");
				
				if(flgFeriado) {
					stb.append(PrecoPagantes.IDOSO.getPagante())
						.append(" Preço com 5% de desconto devido ao feriado R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 5)))
						.append("\n");
				} else {
					stb.append(PrecoPagantes.IDOSO.getPagante())
						.append(" Preço com 40% de desconto R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 40)));
				}
				
				break;
			case Calendar.THURSDAY:
				
				stb.append("HOJE É QUINTA-FEIRA\n")
				.append("\tDESCONTOS DO DIA\n");
				
				if(!flgCarteiraEstudante) {
					stb.append(PrecoPagantes.ESTUDANTE.getPagante())
					.append(" Preço com 30% de desconto R$:")
					.append(String.format("%.2f", calcularDesconto(PrecoPagantes.ESTUDANTE.getPreco(), 30)))
					.append("\n");
				} else {
					stb.append(PrecoPagantes.ESTUDANTE.getPagante())
						.append(" Preço com 35% de desconto devido apresentação de carteirinha R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.ESTUDANTE.getPreco(), 35)))
						.append("\n");
				}
				
				if(flgFeriado) {
					stb.append(PrecoPagantes.IDOSO.getPagante())
						.append(" Preço com 5% de desconto devido ao feriado R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 5)))
						.append("\n");
				} else {
					stb.append(PrecoPagantes.IDOSO.getPagante())
						.append(" Preço com 30% de desconto R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 30)));
				}
				
				break;
			case Calendar.FRIDAY:
				
				stb.append("HOJE É SEXTA-FEIRA\n")
					.append("\tDESCONTOS DO DIA\n")
					.append(PrecoPagantes.CRIANCA.getPagante())
					.append(" Preço com 30% de desconto R$:")
					.append(String.format("%.2f", calcularDesconto(PrecoPagantes.CRIANCA.getPreco(), 30)))
					.append("\n");
				
				if(flgCarteiraEstudante) {
					stb.append(PrecoPagantes.ESTUDANTE.getPagante())
						.append(" Preço com 35% de desconto devido apresentação de carteirinha R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.ESTUDANTE.getPreco(), 35)))
						.append("\n");
				}	
				
				if(flgFeriado) {
					stb.append(PrecoPagantes.IDOSO.getPagante())
						.append(" Preço com 5% de desconto devido ao feriado R$:")
						.append(String.format("%.2f", calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 5)))
						.append("\n");
				}
				
				break;
			case Calendar.SATURDAY:
				
				stb.append("HOJE É SÁBADO\n")
					.append("\tDESCONTOS DO DIA\n")
					.append(PrecoPagantes.IDOSO.getPagante())
					.append(" Preço com 30% de desconto R$:")
					.append(String.format("%.2f", calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 5)))
					.append("\n")
					.append("Carteira de Estudante não é aceita aos finais de semana");
				
				break;
		}

		return stb.toString();
	}

	/**
	 * Método para calcular descontos
	 * @param desconto - desconto a ser dado em porcentagem
	 * @param preco - preço normal do ingresso sem desconto
	 * @return - preço do ingresso calculado com desconto
	 */
	protected static double calcularDesconto(double preco, double desconto) {
			return  preco - ((preco * desconto) / 100);
	}
	
	/**
	 * Método para exibir preços sem desconto 
	 * @return - preços sem desconto
	 */
	protected static String exibirPreco() {
		
		StringBuilder stb = new StringBuilder();
		
		stb.append(PrecoPagantes.CRIANCA.getPagante())
			.append(" Preço R$")
			.append(String.format("%.2f", PrecoPagantes.CRIANCA.getPreco()))
			.append("\n")
			.append(PrecoPagantes.ESTUDANTE.getPagante())
			.append(" Preço R$")
			.append(String.format("%.2f", PrecoPagantes.ESTUDANTE.getPreco()))
			.append("\n")
			.append(PrecoPagantes.IDOSO.getPagante())
			.append(" Preço R$")
			.append(String.format("%.2f", PrecoPagantes.IDOSO.getPreco()))
			.append("\n");
		
		return stb.toString();
	}

}
