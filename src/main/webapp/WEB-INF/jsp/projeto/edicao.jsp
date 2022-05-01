<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Novo Projeto</title>
  	<c:import url="/WEB-INF/jsp/head.jsp"/>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<c:import url="/WEB-INF/jsp/mensagens.jsp"/>
	
	<div class="container mt-3">
	  <c:if test="${not empty projeto}">
	  	<h2>Alterar Projeto</h2>
	  </c:if>
	  <c:if test="${empty projeto}">
	  	<h2>Novo Projeto</h2>
	  </c:if>
	  
	  <form action="/projeto/salvar" method="post">
	  	<input type="hidden" name="id" value="${projeto.id}">
	  	
	  	<c:if test="${not empty projeto.id}">
	  		<input type="hidden" name="iniciado" value="${projeto.iniciado}">
	  	</c:if>
	  	<c:if test="${empty projeto.id}">
	  		<input type="hidden" name="iniciado" value="false">
	  	</c:if>
	    
	    <div class="mb-3 mt-3">
	      <label>Nome:</label>
	      <input type="text" class="form-control" placeholder="Nome" name="nome" value="${projeto.nome}">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Data Início:</label>
	      <input type="date" class="form-control" placeholder="Data Início" name="dataInicio" value="${projeto.dataInicio}">
	    </div>
	    
	    <div class="mb-3 mt-3">
	      <label>Data Fim:</label>
	      <input type="date" class="form-control" placeholder="Data Fim" name="dataFim" value="${projeto.dataFim}">
	    </div>
	    
	    <div class="mb-3 mt-3">
	      <label>Quantidade de Horas:</label>
	      <input type="number" class="form-control" placeholder="Quantidade de Horas" name="quantidadeHoras" value="${projeto.quantidadeHoras}">
	    </div>
		
	    <div class="mb-3 mt-3">
	      <label>Cliente:</label>
	      <select name="cliente.id" class="form-control">
	      	<option value="">Selecione</option>
	      	<c:forEach var="cliente" items="${clientes}">
	      		<c:if test="${cliente.id eq projeto.cliente.id}">
		      		<option value="${cliente.id}" selected>${cliente.nome}</option>
	      		</c:if>
	      		<c:if test="${cliente.id ne projeto.cliente.id}">
		      		<option value="${cliente.id}">${cliente.nome}</option>
	      		</c:if>
	      	</c:forEach>
	      </select>
	    </div>
	    
		<c:if test="${usuarioLogado.perfil.administrador}">
		    <div class="mb-3 mt-3">
		      <label>Gerente:</label>
		      <select name="gerente.id" class="form-control">
		      	<option value="">Selecione</option>
		      	<c:forEach var="gerente" items="${gerentes}">
		      		<c:if test="${gerente.id eq projeto.gerente.id}">
			      		<option value="${gerente.id}" selected>${gerente.nome}</option>
		      		</c:if>
		      		<c:if test="${gerente.id ne projeto.gerente.id}">
			      		<option value="${gerente.id}">${gerente.nome}</option>
		      		</c:if>
		      	</c:forEach>
		      </select>
		    </div>
		</c:if>
	    
	    <button type="submit" class="btn btn-primary">Salvar</button>
	  </form>
	</div>
</body>
</html>