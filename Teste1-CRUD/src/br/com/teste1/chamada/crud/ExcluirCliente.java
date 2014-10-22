package br.com.teste1.chamada.crud;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste1.dao.ClienteDAO;
import br.com.teste1.modelo.Cliente;

public class ExcluirCliente implements LogicaExecutada {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
Cliente cliente = new Cliente();
		
		String id = request.getParameter("id").trim();
		cliente.setId(Long.parseLong(id));
		
		Connection conexao = (Connection) request.getAttribute("conexao");
		ClienteDAO clienteDAO = new ClienteDAO(conexao);
		clienteDAO.excluirCliente(cliente);
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		response.sendRedirect("index.jsp"); // fazer refresh na página  
		//rd.forward(request, response);
		
	}

}
