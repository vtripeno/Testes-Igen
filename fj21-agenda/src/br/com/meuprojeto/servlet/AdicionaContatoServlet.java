package br.com.meuprojeto.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.meuprojeto.dao.ContatoDAO;
import br.com.meuprojeto.modelo.Contato;

@WebServlet(name="AdicionaContato", urlPatterns="/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a servlet");
	}
	
	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch(ParseException e) {
			out.println("Erro de convers�o em data");
		}
		
		Contato contato = new Contato();
		
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		Connection conexao = (Connection) request.getAttribute("conexao");
		ContatoDAO contDAO = null;
		try {
			contDAO = new ContatoDAO(conexao);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		contDAO.adicionar(contato);
		
		//out.println("<html> <body> Contato " + contato.getNome() + " adicionado com sucesso </body> </html>");
		
		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
		
		
		
	}
}
