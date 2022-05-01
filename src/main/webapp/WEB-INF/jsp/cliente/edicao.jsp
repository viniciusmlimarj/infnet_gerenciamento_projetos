<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Novo Cliente</title>
  	<c:import url="/WEB-INF/jsp/head.jsp"/>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<c:import url="/WEB-INF/jsp/mensagens.jsp"/>
	
	<div class="container mt-3">
	  <c:if test="${not empty cliente}">
	  	<h2>Alterar Cliente</h2>
	  </c:if>
	  <c:if test="${empty cliente}">
	  	<h2>Novo Cliente</h2>
	  </c:if>
	  
	  <form action="/cliente/salvar" method="post">
	  	<input type="hidden" name="id" value="${cliente.id}">
	    <div class="mb-3 mt-3">
	      <label>Nome:</label>
	      <input type="text" class="form-control" placeholder="Nome" name="nome" value="${cliente.nome}">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>E-mail:</label>
	      <input type="email" class="form-control" placeholder="Email" name="email" value="${cliente.email}">
	    </div>
		
	    <button type="submit" class="btn btn-primary">Salvar</button>
	  </form>
	</div>
</body>
</html>