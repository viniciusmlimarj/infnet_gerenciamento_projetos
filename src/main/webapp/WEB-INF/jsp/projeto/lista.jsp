<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Projetos</title>
	<c:import url="/WEB-INF/jsp/head.jsp"/>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<c:import url="/WEB-INF/jsp/mensagens.jsp"/>
	
	<div class="container mt-3">
	  <h2>Projetos</h2>
	  
	  <c:if test="${usuarioLogado.perfil.administrador or usuarioLogado.perfil.gerente}">
		  <form action="/projeto/novo" method="get">
		    <button type="submit" class="btn btn-primary">Novo Projeto</button>
		  </form>
	  </c:if>

	  <c:if test="${not empty lista}">
		  <table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Nome</th>
		        <th>Data Início</th>
		        <th>Data Fim</th>
		        <th>Quantidade de Horas</th>
		        <th>Cliente</th>
		        <th>Gerente</th>
	        	<th></th>
	        	<th></th>
	        	<th></th>
	        	<c:if test="${usuarioLogado.perfil.administrador or usuarioLogado.perfil.gerente}">
		        	<th></th>
		        	<th></th>
		        </c:if>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="o" items="${lista}">	
			      <tr>
			        <td>${o.nome}</td>
			        <td>${o.dataInicio}</td>
			        <td>${o.dataFim}</td>
			        <td>${o.quantidadeHoras}</td>
			        <td>${o.cliente.nome}</td>
			        <td>${o.gerente.nome}</td>
			        <c:if test="${not o.iniciado}">
			        	<td><a href="/projeto/${o.id}/iniciar">Iniciar</a></td>
			        	<td></td>
			        	<td></td>
			        </c:if>
			        <c:if test="${o.iniciado}">
			        	<td>Projeto Iniciado</td>
			        	<td><a href="/projeto/${o.id}/tarefa">Tarefas</a></td>
			        	<c:if test="${usuarioLogado.perfil.administrador or usuarioLogado.perfil.gerente}">
			        		<td><a href="/projeto/${o.id}/recurso">Recursos</a></td>
			        	</c:if>
						<c:if test="${not usuarioLogado.perfil.administrador and not usuarioLogado.perfil.gerente}">
				        	<td></td>
			        	</c:if>
			        </c:if>
			        <c:if test="${usuarioLogado.perfil.administrador or usuarioLogado.perfil.gerente}">
			        	<td><a href="/projeto/${o.id}">Alterar</a></td>
			        	<td><a href="/projeto/${o.id}/excluir">Excluir</a></td>
		        	</c:if>
			      </tr>
		      </c:forEach>
		    </tbody>
		  </table>
	  </c:if>
		
 	  <c:if test="${empty lista}">
 	  	<p>Nenhum registro encontrado.</p>
 	  </c:if> 	              
	</div>
</body>
</html>