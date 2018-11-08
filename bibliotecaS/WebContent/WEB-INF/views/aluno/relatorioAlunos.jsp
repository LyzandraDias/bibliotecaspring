<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Relatórios Detalhados</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<style>
</style>
</head>
<body>
				<c:import url="../menu.jsp"></c:import>
				<div id="this">
			
					<!-- Emprestimos em dias -->
					<table class="panel">
						<tr>
							<th>Alunos com emprestimos em dias</th>
						</tr>
						<c:forEach var="aluno" items="${alunosD }">
							<tr>
								<td>
									<!-- Emprestimos deste Aluno -->
									<table class="panel gerenc">
										<tr>
											<th>${aluno.nome } (${aluno.matricula })</th>
											<th>Titulo</th>
											<th>Data Emp.</th>
											<th>Data Dev.</th>
			
											<th>Gerenciamento</th>
										</tr>
			
										<c:forEach var="emprestimo" items="${aluno.emprestimos }">
											<tr bgcolor="#${emprestimo.status? '80f080' : 'f08080' }"
												style="padding: 2px;">
												<td></td>
												<td>${emprestimo.livro.titulo }</td>
												<td><fmt:formatDate value="${emprestimo.dataEmp.time }"
														pattern="dd/MM/yyyy" /></td>
												<td><fmt:formatDate value="${emprestimo.dataDev.time }"
														pattern="dd/MM/yyyy" /></td>
			
												<th><a
													href="/Biblioteca/livro/devolve?id=${emprestimo.livro.id }">Finalizar</a></th>
											</tr>
										</c:forEach>
									</table>
								</td>
							</tr>
						</c:forEach>
					</table>
			
					<!-- Emprestimos atrasados -->
					<table class="panel lista">
						<tr>
							<th>Alunos com emprestimos em atraso</th>
						</tr>
			
						<c:forEach var="aluno" items="${alunosA }">
							<tr>
								<td>
									<!-- Todos os emprestimos deste aluno -->
									<table class="panel gerenc">
										<tr>
											<th>${aluno.nome } (${aluno.matricula })</th>
											<th>Titulo</th>
											<th>Data Emp.</th>
											<th>Data Dev.</th>
			
											<th>Gerenciamento</th>
										</tr>
			
										<c:forEach var="emprestimo" items="${aluno.emprestimos }">
											<tr bgcolor="#${emprestimo.status? '80f080' : 'f08080' }"
												style="padding: 2px;">
												<td></td>
												<td>${emprestimo.livro.titulo }</td>
												<td><fmt:formatDate value="${emprestimo.dataEmp.time }"
														pattern="dd/MM/yyyy" /></td>
												<td><fmt:formatDate value="${emprestimo.dataDev.time }"
														pattern="dd/MM/yyyy" /></td>
			
												<th><a
													href="/Biblioteca/livro/devolve?id=${emprestimo.livro.id }">Finalizar</a></th>
											</tr>
										</c:forEach>
									</table>
								</td>
							</tr>
						</c:forEach>
					</table>
			
					<!-- Todos os Emprestimos -->
					<table class="panel lista">
						<tr>
							<th>Todos os emprestimos já realisados</th>
						</tr>
						<tr>
							<td>
								<table class="panel gerenc">

						<tr>
							<th>Aluno</th>
							<th>Titulo</th>
							<th>Data Emp.</th>
							<th>Data Dev.</th>

							<th>Gerenciamento</th>
						</tr>

						<c:forEach var="emprestimo" items="${emprestimos }">
							<tr bgcolor="#${emprestimo.status? '80f080' : 'f08080' }"
								style="padding: 2px;">
								<td>${emprestimo.aluno.nome }(${emprestimo.aluno.matricula })</td>
								<td>${emprestimo.livro.titulo }</td>
								<td><fmt:formatDate value="${emprestimo.dataEmp.time }"
										pattern="dd/MM/yyyy" /></td>
								<td><fmt:formatDate value="${emprestimo.dataDev.time }"
										pattern="dd/MM/yyyy" /></td>

								<th><a
									href="/Biblioteca/livro/devolve?id=${emprestimo.livro.id }">Finalizar</a></th>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>

	</div>
	<c:import url="/resources/footer.jsp" />
</body>
</html>