<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Recursos</title>
	<c:import url="/WEB-INF/jsp/head.jsp"/>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<c:import url="/WEB-INF/jsp/mensagens.jsp"/>
	
	<div class="container mt-3">
	  <h2>Recursos</h2>
	  
	  <c:if test="${usuarioLogado.perfil.administrador or usuarioLogado.perfil.gerente}">
		  <form action="/projeto/${idProjeto}/recurso/associar" method="post">
		    <div class="mb-3 mt-3">
		      <label>Adicionar Recurso:</label>
		      <select name="idRecurso" class="form-control">
		      	<option value="">Selecione</option>
		      	<c:forEach var="funcionario" items="${funcionarios}">
		      		<option value="${funcionario.id}">${funcionario.nome}</option>
		      	</c:forEach>
		      </select>
		    </div>
		    <button type="submit" class="btn btn-primary">Salvar</button>
		  </form>
	  </c:if>
	  
	  <c:if test="${not empty lista}">
		  <table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Recurso</th>
		        <c:if test="${usuarioLogado.perfil.administrador or usuarioLogado.perfil.gerente}">
		        	<th></th>
		        </c:if>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="o" items="${lista}">	
			      <tr>
			        <td>${o.nome}</td>
			        <c:if test="${usuarioLogado.perfil.administrador or usuarioLogado.perfil.gerente}">
			        	<td><a href="/projeto/${idProjeto}/recurso/${o.id}/excluir">Excluir</a></td>
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