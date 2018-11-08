<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bibliotecaspring.models.Livro"%>
<%@page import="java.util.List"%>
<%@page import="bibliotecaspring.daos.LivroDAO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
</head>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Lista dos livros:</h1>
	
		<table border="2">
		<thead>
		<tr>
			<th>Titulo</th>
			<th>Autor</th>
			<th>Editora</th>
			<th>Publicação</th>
			<th>Ed.</th>					
		</tr>
		</thead>
		
	<tbody>
		<c:forEach var="livro" items="${livros }" >
		
		<tr>
			<td>${livro.titulo }</td>
			<td>${livro.autor }</td>
			<td>${livro.editora }</td>
			<td>${livro.publicacao.time }</td>
			<td>${livro.edicao } .ed</td>
			
			<td><a href = "/Bibliotecaspring/livro/remove?id=${livro.id }">Remover.</a></td>
			<td><a href = "/Bibliotecaspring/livro/altera?id=${livro.id }">Alterar.</a></td>
				
		</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>