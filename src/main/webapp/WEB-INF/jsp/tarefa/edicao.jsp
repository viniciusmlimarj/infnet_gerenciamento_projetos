<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Novo Tarefa</title>
  	<c:import url="/WEB-INF/jsp/head.jsp"/>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<c:import url="/WEB-INF/jsp/mensagens.jsp"/>
	
	<div class="container mt-3">
	  <c:if test="${not empty tarefa}">
	  	<h2>Alterar Tarefa</h2>
	  </c:if>
	  <c:if test="${empty tarefa}">
	  	<h2>Nova Tarefa</h2>
	  </c:if>
	  
	  <form action="/tarefa/salvar" method="post">
	  	<input type="hidden" name="id" value="${tarefa.id}">
		
		<c:if test="${not empty idProjeto}">
		    <input type="hidden" name="projeto.id" value="${idProjeto}"/>
		</c:if>
		<c:if test="${empty idProjeto and not usuarioLogado.perfil.administrador and not usuarioLogado.perfil.gerente}">
		    <input type="hidden" name="projeto.id" value="${projeto.id}"/>
		</c:if>
		<c:if test="${empty idProjeto and (usuarioLogado.perfil.administrador or usuarioLogado.perfil.gerente)}">
		    <div class="mb-3 mt-3">
		      <label>Projeto:</label>
		      <select name="projeto.id" class="form-control">
		      	<option value="">Selecione</option>
		      	<c:forEach var="projeto" items="${projetos}">
		      		<c:if test="${projeto.id eq tarefa.projeto.id}">
			      		<option value="${projeto.id}" selected>${projeto.nome}</option>
		      		</c:if>
		      		<c:if test="${projeto.id ne tarefa.projeto.id}">
			      		<option value="${projeto.id}">${projeto.nome}</option>
		      		</c:if>
		      	</c:forEach>
		      </select>
		    </div>
		</c:if>
		
		<c:if test="${not empty idFuncionario}">
		    <input type="hidden" name="funcionario.id" value="${idFuncionario}"/>
		</c:if>
		<c:if test="${empty idFuncionario}">
		    <div class="mb-3 mt-3">
		      <label>Responsável:</label>
		      <select name="funcionario.id" class="form-control">
		      	<option value="">Selecione</option>
		      	<c:forEach var="funcionario" items="${funcionarios}">
		      		<c:if test="${funcionario.id eq tarefa.funcionario.id}">
			      		<option value="${funcionario.id}" selected>${funcionario.nome}</option>
		      		</c:if>
		      		<c:if test="${funcionario.id ne tarefa.funcionario.id}">
			      		<option value="${funcionario.id}">${funcionario.nome}</option>
		      		</c:if>
		      	</c:forEach>
		      </select>
		    </div>
		</c:if>
		
	    <div class="mb-3 mt-3">
	      <label>Titulo:</label>
	      <input type="text" class="form-control" placeholder="Titulo" name="titulo" value="${tarefa.titulo}">
	    </div>
		
	    <div class="mb-3 mt-3">
	      <label>Descrição:</label>
	      <input type="text" class="form-control" placeholder="Descrição" name="descricao" value="${tarefa.descricao}">
	    </div>
	    
	    <div class="mb-3 mt-3">
	      <label>Status:</label>
	      <select name="status" id="status" class="form-control">
	      	<option value="">Selecione</option>
	      	<option value="1">Backlog</option>
	      	<option value="2">Em Andamento</option>
	      	<option value="3">Finalizada</option>
	      	<option value="4">Bloqueada</option>
	      </select>
	    </div>
	    <script type="text/javascript">$('#status').val(${tarefa.status})</script>
		
	    <button type="submit" class="btn btn-primary">Salvar</button>
	  </form>
	</div>
</body>
</html>