<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="victor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	Formulário para alteração de contatos:<br/>
	<form action="mvc" method="POST">
		Id:
		<input name="id"><br>
		Nome:
		<input name="nome"><br>
		E-mail:
		<input name="email"><br>
		Endereço:
		<input type="text"name="endereco"><br>
		Data de Nascimento:
		<victor:campoData id="dataNascimento" />
		<input type="hidden"
		name="logica" value="AlterarContatoLogic">
		<input type="submit" value="Enviar">
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>