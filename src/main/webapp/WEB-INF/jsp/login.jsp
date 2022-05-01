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
	<div class="container mt-3">
	  <h2>Autenticação</h2>
	  
	  <c:import url="/WEB-INF/jsp/mensagens.jsp"/>
			  
	  <form action="/login" method="post">

	    <div class="mb-3 mt-3">
	      <label>Email:</label>
	      <input type="email" class="form-control" name="email" value="vinicius.lima@al.infnet.edu.br">
	    </div>

	    <div class="mb-3">
	      <label>Password:</label>
	      <input type="password" class="form-control" name="senha" value="P@ssw0rd">
	    </div>

	    <button type="submit" class="btn btn-primary">Acessar</button>
	  </form>
	</div>
</body>
</html>