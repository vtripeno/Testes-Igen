package br.com.teste1.chamada.crud;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste1.dao.ClienteDAO;
import br.com.teste1.modelo.Cliente;

public class AdicionarCliente implements LogicaExecutada {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Cliente cliente = new Cliente();
		
		cliente.setNome(request.getParameter("nome").trim());
		cliente.setCpf(request.getParameter("cpf").trim());
		cliente.setEmail(request.getParameter("email").trim());
		
		
		
		Connection conexao = (Connection) request.getAttribute("conexao");
		ClienteDAO clienteDAO = new ClienteDAO(conexao);
		clienteDAO.adicionarCliente(cliente);
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		response.sendRedirect("index.jsp"); // fazer refresh na página
		//rd.forward(request, response);
		
	}

}
