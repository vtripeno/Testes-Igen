<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/metodos_simples.js"></script>
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery-1.11.1.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>
<title>Teste 1 - CRUD</title>
</head>
<body>

<jsp:useBean id="dao" class="br.com.teste1.dao.ClienteDAO"/>

<table>
	<tr>
		<td><input type="radio" checked="checked" name="Radio" onclick="clica('Gravar')">Gravar</input></td>
		<td><input type="radio" name="Radio" onclick="clica('Alterar')">Alterar</input></td>
		<td><input type="radio" name="Radio" onclick="clica('Excluir')">Excluir</input></td>
	</tr>
</table>
	<form action="controlador" method="POST" name="formCRUD">
		<table>
			<tr>
				<td>ID:</td> <td><input type="text" name="id" id="id" disabled="disabled"/></td>
			</tr>
			<tr>
				<td>Nome:</td> <td><input type="text" name="nome" id="nome"/></td>
			</tr>
			<tr> 
				<td>CPF:</td> <td><input type="text" name="cpf" id="cpf" maxlength="11"/></td>
			</tr>
			<tr>
				<td>E-mail:</td> <td><input type="text" name="email" id="email"/></td>
			</tr>
		</table>
		<input type="hidden" name="control" id="control" value="AdicionarCliente">
			<br /> <input type="submit" value="Gravar" id="btAcao"/>
	</form>

	<br />
	<br />
		
	<table border="1" id="tabela">
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>CPF</td>
			<td>E-mail</td>
			<c:forEach var="cliente" items="${dao.cliente}" varStatus="cont">
				<tr bgcolor="#${cont.count % 2 == 0 ? '87CEFA' : 'FF6347'}">
					<td>${cliente.id}</td> 
					<td>${cliente.nome}</td>
					<td>${cliente.cpf}</td>
					<td>
						<c:choose>
							<c:when test="${not empty cliente.email}">
								${cliente.email}
							</c:when>
							<c:otherwise>
								E-mail não informado
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</table>	
	
</body>
</html>