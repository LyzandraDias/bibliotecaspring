<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bibliotecaspring.models.Emprestimo"%>
<%@page import="java.util.List"%>
<%@page import="bibliotecaspring.daos.EmprestimoDAO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
	<c:import url="../menu.jsp"></c:import>
	<h1>olhar o cadastro de emprestimo:</h1>
	
		<table border="2">
		<thead>
		<tr>
			<th>Aluno</th>
			<th>Livro</th>
			<th>Data do Emprestimo</th>					
		</tr>
		</thead>
		
	<tbody>
		<c:forEach var="emprestimo" items="${emprestimo}" >
		
		<tr>
			<td>${emprestimo.aluno }</td>
			<td>${emprestimo.livro }</td>
			<td>${emprestimo.dataEmprestimo }</td>
			
			
			<td><a href = "/Bibliotecaspring/livro/remove?id=${livro.id }">Remover.</a></td>
			<td><a href = "/Bibliotecaspring/livro/altera?id=${livro.id }">Alterar.</a></td>
				
		</tr>
		</c:forEach>
		</tbody>
	</table>
</html>