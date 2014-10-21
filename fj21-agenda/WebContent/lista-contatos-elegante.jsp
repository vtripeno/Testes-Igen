<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:import url="cabecalho.jsp"/>

<jsp:useBean id="dao" class="br.com.meuprojeto.dao.ContatoDAO"/>

<table border="1">
	<tr>
		<td>Nome</td>
		<td>Endere�o</td>
		<td>E-mail</td>
		<td>Data de Nascimento</td>
		<c:forEach var="contato" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'aa88ee'}">
				<td>${contato.nome}</td>
				<td>${contato.endereco}</td>
				<td>
					<c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							E-mail n�o informado
						</c:otherwise>
					</c:choose>
				</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
			</tr>
		</c:forEach>
	</tr>
</table>




<c:import url="rodape.jsp"/>

</body>
</html>