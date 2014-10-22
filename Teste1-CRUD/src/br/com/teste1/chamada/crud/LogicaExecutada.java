package br.com.teste1.chamada.crud;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LogicaExecutada {
	void executa(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
