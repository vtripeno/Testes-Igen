package br.com.meuporjeto.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.meuprojeto.dao.ConnectionFactory;

@WebFilter(filterName="FiltroConexao", urlPatterns="/*")
public class FiltroConexao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			Connection conexao = new ConnectionFactory().open();
			
			// pendurando a request da requisicao
			request.setAttribute("conexao", conexao);
			
			chain.doFilter(request, response);
			
			conexao.close();
		} catch(SQLException e) {
			throw new ServletException(e);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
