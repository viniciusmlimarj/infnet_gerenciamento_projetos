<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Clientes</title>
	<c:import url="/WEB-INF/jsp/head.jsp"/>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<c:import url="/WEB-INF/jsp/mensagens.jsp"/>
	
	<div class="container mt-3">
	  <h2>Clientes</h2>
	  
	  <c:if test="${usuarioLogado.perfil.administrador or usuarioLogado.perfil.gerente}">
		  <form action="/cliente/novo" method="get">
		    <button type="submit" class="btn btn-primary">Novo Cliente</button>
		  </form>
	  </c:if>

	  <c:if test="${not empty lista}">
		  <table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Nome</th>
		        <th>E-mail</th>
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
			        <td>${o.email}</td>
			        <c:if test="${usuarioLogado.perfil.administrador or usuarioLogado.perfil.gerente}">
			        	<td><a href="/cliente/${o.id}">Alterar</a></td>
			        	<td><a href="/cliente/${o.id}/excluir">Excluir</a></td>			        
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