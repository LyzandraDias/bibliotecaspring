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
<h1>Adicionar livro</h1>
	<form action="/Bibliotecaspring/livros" method="post">
		<input type="hidden" name="comando" value="AdicionarLivro">
		<div>
			<label>Titulo: </label> 
			<input type="text" name="titulo">
		</div>
		<div>
			<label>Autor: </label> 
			<input type="text" name="autor">
		</div>
		<div>
			<label>Editora: </label> 
			<input type="text" name="editora">
		</div>
		<div>
			<label>Ano de publicação: </label>
			<input type="text" name="publicacao">
		</div>
		<div>
			<label>Edição: </label>
			<input type="text" name="edicao">
		</div>
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>

</body>
</html>