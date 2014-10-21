package br.com.meuprojeto.dao;

import java.sql.Connection;

public class TestaConexao {

	public static void main(String[] args) throws Exception {
		Connection con = new ConnectionFactory().open();
		System.out.println("Conectou");
		con.close();
	}
}
