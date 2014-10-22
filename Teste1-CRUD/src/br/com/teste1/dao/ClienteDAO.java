package br.com.teste1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.teste1.modelo.Cliente;

public class ClienteDAO {

	private Connection conexao;
	
	public ClienteDAO() throws Exception {
		this.conexao = new FabricaConexao().open();
	}
	
	public ClienteDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void adicionarCliente(Cliente cliente) {
		String sql = "INSERT INTO clientes (nome, cpf, email) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmail());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterarCliente(Cliente cliente) {
		String sql = "UPDATE clientes SET nome = ?, cpf = ?, email = ? WHERE id_cliente = ?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmail());
			stmt.setLong(4, cliente.getId());
			
			stmt.execute();
			stmt.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluirCliente(Cliente cliente) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM clientes WHERE id_cliente = ?");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Cliente> getCliente() {
		try {
			List<Cliente> clientesLista = new ArrayList<Cliente>();
			PreparedStatement stmt = conexao.prepareStatement("SELECT id_cliente, nome, cpf, email FROM clientes ORDER BY id_cliente");
			ResultSet rs = stmt.executeQuery();
			while( rs.next() ) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				
				clientesLista.add(cliente);
				
			}
			rs.close();
			return clientesLista;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
