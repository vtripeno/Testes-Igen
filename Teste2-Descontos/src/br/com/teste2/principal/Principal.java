package br.com.teste2.principal;

import java.util.Date;

import br.com.teste2.pagantes.descontos.DescontosDias;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date hoje = new Date(); 
		
		System.out.println(DescontosDias.verificarDesconto(hoje, true, false));
		
	}

}
