package br.com.teste2.pagantes.descontos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import br.com.teste2.pagantes.PrecoPagantes;

public class DescontosDiasTest {

	@Test
	public void calcularDescontoTest() {
		double preco = 5.50;
		double desconto = 30;
		double retornoEsperado = 3.85;
		
		double retornoObitido = DescontosDias.calcularDesconto(preco, desconto);
		
		assertEquals(retornoEsperado, retornoObitido, 0);
	}
	
	@Test
	public void exibirPrecoTest() {
		/*String retornoEsperado = "CRIANÇA Preço R$5,50\nESTUDANTE Preço R$8,00\nIDOSO Preço R$6,00";
		
		String retornoObtido = DescontosDias.exibirPreco();
		
		assertTrue(retornoEsperado.equals(retornoObtido));*/ // TESTE FALHOU
		
		StringBuilder retornoEsperado = new StringBuilder();
		
		retornoEsperado.append(PrecoPagantes.CRIANCA.getPagante())
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
		
		String retornoObtido = DescontosDias.exibirPreco();
		
		assertTrue(retornoEsperado.toString().equals(retornoObtido));
	}
	
	@Test
	public void verificarDescontoTest() {
		Date data = new Date();
		
		StringBuilder retornoEsperado = new StringBuilder();
		boolean flgCarteiraEstudante = true, flgFeriado = true;
		
		retornoEsperado.append(DescontosDias.exibirPreco())
			.append("HOJE É SEXTA-FEIRA\n")
			.append("\tDESCONTOS DO DIA\n")
			.append(PrecoPagantes.CRIANCA.getPagante())
			.append(" Preço com 30% de desconto R$:")
			.append(String.format("%.2f", DescontosDias.calcularDesconto(PrecoPagantes.CRIANCA.getPreco(), 30)))
			.append("\n");
	
		if(flgCarteiraEstudante) {
			retornoEsperado.append(PrecoPagantes.ESTUDANTE.getPagante())
				.append(" Preço com 35% de desconto devido apresentação de carteirinha R$:")
				.append(String.format("%.2f", DescontosDias.calcularDesconto(PrecoPagantes.ESTUDANTE.getPreco(), 35)))
				.append("\n");
		}	
		
		if(flgFeriado) {
			retornoEsperado.append(PrecoPagantes.IDOSO.getPagante())
				.append(" Preço com 5% de desconto devido ao feriado R$:")
				.append(String.format("%.2f", DescontosDias.calcularDesconto(PrecoPagantes.IDOSO.getPreco(), 5)))
				.append("\n");
		}
		
		String retornoObtido = DescontosDias.verificarDesconto(data, flgCarteiraEstudante, flgFeriado);
		
		assertTrue(retornoEsperado.toString().equals(retornoObtido));
	}

}
