package br.com.meuprojeto.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.meuprojeto.dao.ContatoDAO;
import br.com.meuprojeto.modelo.Contato;

public class AlterarContatoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Contato contato = new Contato();
		
		String id = request.getParameter("id");
		contato.setId(Long.parseLong(id));
		
		contato.setNome(request.getParameter("nome"));
		contato.setEndereco(request.getParameter("endereco"));
		contato.setEmail(request.getParameter("email"));
		
		String dataEmTxt = request.getParameter("dataNascimento");
		Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTxt);
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(data);
		
		contato.setDataNascimento(dataNascimento);
		
		Connection conexao = (Connection) request.getAttribute("conexao");
		ContatoDAO contatoDAO = new ContatoDAO(conexao);
		contatoDAO.altera(contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(request, response);
		
		System.out.println("Alterando contato " + contato.getNome());
		
	}

}
