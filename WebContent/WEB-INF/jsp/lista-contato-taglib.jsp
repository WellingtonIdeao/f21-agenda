<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de contatos com taglib</title>
</head>
<body>
<c:import url="cabecalho.jsp"></c:import>
		<table>
				<tr>
					<th>${"Nome"}</th>
					<th>${"E-mail"}</th>
					<th>${"Endereco"}</th>
					<th>${"Data de Nascimento"}</th>
					<th>${"Ação"}</th>
				</tr>
			<c:forEach var="contato" items="${contatos}">
				<tr>
					<td>${contato.nome}</td>
					<td>
						<c:choose>
							<c:when test="${not empty contato.email }">
								<a href="mailto:${contato.email}">${contato.email}</a>
							</c:when>
							<c:otherwise>
								E-mail não informado
							</c:otherwise>
						</c:choose>
					
					</td>				
					<td>${contato.endereco}</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
					<td><a href="sistema?logica=RemoverLogic&id=${contato.id}">Remover</a></td>
					
				</tr>
				
			</c:forEach>
		</table>
		
<c:import url="rodape.jsp"></c:import>
		
</body>
</html>