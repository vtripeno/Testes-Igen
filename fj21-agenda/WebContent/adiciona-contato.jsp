<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="victor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Contato</title>
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>

	<form action="adicionaContato">
		Nome: <input type="text" name="nome" /><br />
		E-mail: <input type="text" name="email" /><br />
		Endereço: <input type="text" name="endereco" /><br />
		<!-- Data Nascimento: <input type="text" name="dataNascimento" /><br />-->
		Data Nascimento: <victor:campoData id="dataNascimento" /><br />
		
		<input type="submit" value="Gravar" />
	</form>
	
	<c:import url="rodape.jsp"></c:import>
</body>
</html>