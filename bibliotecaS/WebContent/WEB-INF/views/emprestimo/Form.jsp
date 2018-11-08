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
<h1>Adicionar aluno</h1>
	<form action="/Bibliotecaspring/emprestimos" method="post">
		<input type="hidden" name="comando" value="AdicionarEmprestimo">
		<div>
			<label>Aluno: </label> 
			<input type="text" name="matricula">
		</div>
		<div>
			<label> livro: </label> 
			<input type="text" name="nome">
		</div>
		<div>
			<label>Data do Emprestimo: </label> 
			<input type="text" name="DataEmprestimo">
		</div>
			
			<button type="submit">Adicionar</button>
		</div>
	</form>

</body>
</html>