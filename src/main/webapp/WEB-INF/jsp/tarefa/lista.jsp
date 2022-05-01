<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Tarefas</title>
	<c:import url="/WEB-INF/jsp/head.jsp"/>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<c:import url="/WEB-INF/jsp/mensagens.jsp"/>
	
	<div class="container mt-3">
	  <h2>Tarefas</h2>
	  
	  <form action="/tarefa/novo" method="get">
	  	<input type="hidden" name="idProjeto" value="${idProjeto}" />
	    <button type="submit" class="btn btn-primary">Nova Tarefa</button>
	  </form>
				
	  <c:if test="${not empty lista}">
		  <table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Projeto</th>
		        <th>Funcionário</th>
		        <th>Titulo</th>
		        <th>Status</th>
	        	<th></th>
	        	<th></th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="o" items="${lista}">	
			      <tr>
			        <td>${o.projeto.nome}</td>
			        <td>${o.funcionario.nome}</td>
			        <td>${o.titulo}</td>
			        <td>
			        	<c:if test="${o.status eq 1}">Backlog</c:if>
			        	<c:if test="${o.status eq 2}">Em Andamento</c:if>
			        	<c:if test="${o.status eq 3}">Finalizada</c:if>
			        	<c:if test="${o.status eq 4}">Bloqueada</c:if>
			        </td>
		        	<td><a href="/tarefa/${o.id}">Alterar</a></td>
		        	<td><a href="/tarefa/${o.id}/excluir">Excluir</a></td>			        
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