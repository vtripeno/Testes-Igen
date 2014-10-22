package br.com.teste1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste1.chamada.crud.LogicaExecutada;

@WebServlet(name="controlador", urlPatterns="/controlador")
public class ControleServlet extends HttpServlet {

	/**
	 * Saber qual a servlet que será chamada
	 */
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("control");
		String nomeDaClasse = "br.com.teste1.chamada.crud." + parametro;
		try {
			Class classe = Class.forName(nomeDaClasse);
			LogicaExecutada logica = (LogicaExecutada) classe.newInstance();
			logica.executa(request, response);
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
}
