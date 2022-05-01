<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Usuários</title>
	<c:import url="/WEB-INF/jsp/head.jsp"/>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<c:import url="/WEB-INF/jsp/mensagens.jsp"/>
	
	<div class="container mt-3">
	  <h2>Usuários</h2>
	  
	  <c:if test="${usuarioLogado.perfil.administrador}">
		  <form action="/usuario/novo" method="get">
		    <button type="submit" class="btn btn-primary">Novo Usuário</button>
		  </form>
	  </c:if>

	  <c:if test="${not empty lista}">
		  <table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Nome</th>
		        <th>Perfil</th>
		        <th>E-mail</th>
		        <c:if test="${usuarioLogado.perfil.administrador}">
		        	<th></th>
		        	<th></th>
		        </c:if>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="o" items="${lista}">	
			      <tr>
			        <td>${o.nome}</td>
			        <td>${o.perfil.nome}</td>
			        <td>${o.email}</td>
			        <c:if test="${usuarioLogado.perfil.administrador}">
			        	<td><a href="/usuario/${o.id}">Alterar</a></td>
			        	<td><a href="/usuario/${o.id}/excluir">Excluir</a></td>
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