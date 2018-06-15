<!DOCTYPE html>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib	tagdir="/WEB-INF/tags" prefix="caelum"%>
<html>
<link	href="js/jquery-ui.css" rel="stylesheet">
<script	src="js/jquery.js"></script>
<script	src="js/jquery-ui.js"></script>

	<head><meta charset="ISO-8859-1">
		<title>Adicionar Contato</title>
	</head>
<body>
<c:import url="/WEB-INF/cabecalho.jsp"></c:import>
		<form action="sistema">
			Nome: <input type = "text" name  = "nome"/><br/>
			E-mail: <input type = "text" name  = "email"/><br/>
			Endereço: <input type = "text" name  = "endereco"/><br/>
			DataNascimento: <caelum:campoData id="dataNascimento"/><br/>
			
			<input type = "submit" value= "gravar"/>
		</form>
		
		<form action= "contador">
			<input type ="submit"  value = "contador"/>
		</form>
<c:import url="/WEB-INF/rodape.jsp"></c:import>		
	</body>
</html>