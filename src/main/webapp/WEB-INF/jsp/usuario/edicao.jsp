<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Novo Usu�rio</title>
  	<c:import url="/WEB-INF/jsp/head.jsp"/>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<c:import url="/WEB-INF/jsp/mensagens.jsp"/>

	<div class="container mt-3">
	  <c:if test="${not empty usuario}">
	  	<h2>Alterar Usu�rio</h2>
	  </c:if>
	  <c:if test="${empty usuario}">
	  	<h2>Novo Usu�rio</h2>
	  </c:if>
	  
	  <form action="/usuario/salvar" method="post">
	  	<input type="hidden" name="id" value="${usuario.id}">
	    <div class="mb-3 mt-3">
	      <label>Nome:</label>
	      <input type="text" class="form-control" placeholder="Nome" name="nome" value="${usuario.nome}">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>E-mail:</label>
	      <input type="email" class="form-control" placeholder="Email" name="email" value="${usuario.email}">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Senha:</label>
	      <input type="password" class="form-control" placeholder="Senha">
	    </div>
		
	    <div class="mb-3 mt-3">
	      <label>Perfil:</label>
	      <select name="perfil.id" class="form-control">
	      	<option value="">Selecione</option>
	      	<c:forEach var="perfil" items="${perfis}">
	      		<c:if test="${perfil.id eq usuario.perfil.id}">
		      		<option value="${perfil.id}" selected>${perfil.nome}</option>
	      		</c:if>
	      		<c:if test="${perfil.id ne usuario.perfil.id}">
		      		<option value="${perfil.id}">${perfil.nome}</option>
	      		</c:if>
	      	</c:forEach>
	      </select>
	    </div>
	    
	    <button type="submit" class="btn btn-primary">Salvar</button>
	  </form>
	</div>
</body>
</html>