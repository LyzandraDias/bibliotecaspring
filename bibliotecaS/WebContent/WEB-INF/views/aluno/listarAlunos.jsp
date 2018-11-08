<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bibliotecaspring.models.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="bibliotecaspring.daos.AlunoDAO"%>
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
	<h1>Lista de alunos:</h1>

	<table border="2">
	<thead>
		<tr>
			<th>Matricula</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>Endereço</th>
			<th>Nascimento</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach var="aluno" items="${alunos}">
			<tr>
				<td>${aluno.matricula }</td>
				<td>${aluno.nome }</td>
				<td>${aluno.cpf }</td>
				<td>${aluno.endereco }</td>
				<td>${aluno.dataNascimento.time }</td>

				<td><a href="/Bibliotecaspring/aluno/remove?id=${aluno.id }">Remover</a></td>
				<td><a href="/Bibliotecaspring/aluno/altera?id=${aluno.id }">Alterar.</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>