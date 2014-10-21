package br.com.meuprojeto.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.meuprojeto.modelo.Contato;

public class ContatoDAO {

	private Connection conexao;
	
	public ContatoDAO() throws Exception {
		this.conexao = new ConnectionFactory().open();
	}
	
	public ContatoDAO(Connection conexao) throws Exception {
		this.conexao = conexao;
	}
	
	public void adicionar(Contato contato) {
		String sql = "insert into contatos (nome, email, endereco, dataNascimento)" +
					 "values (?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis() ) );
			
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
	
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = conexao.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			while( rs.next() ) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("Id"));
				contato.setNome(rs.getString("Nome"));
				contato.setEmail(rs.getString("Email"));
				contato.setEndereco(rs.getString("Endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			conexao.close();
			return contatos;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?," +
				 		"dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	 }
	
	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("delete" +
			"from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
