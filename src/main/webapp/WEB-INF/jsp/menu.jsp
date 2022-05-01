<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Projetos</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<c:if test="${not empty usuarioLogado}">
				<c:if test="${usuarioLogado.perfil.administrador}">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">Usuário
						<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/usuario">Listar</a></li>
							<li><a href="/usuario/novo">Novo</a></li>
						</ul>
					</li>
				</c:if>
				<c:if test="${usuarioLogado.perfil.administrador or usuarioLogado.perfil.gerente}">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">Cliente
						<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/cliente">Listar</a></li>
							<li><a href="/cliente/novo">Novo</a></li>
						</ul>
					</li>
				</c:if>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">Projeto
					<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/projeto">Listar</a></li>
						<c:if test="${usuarioLogado.perfil.administrador or usuarioLogado.perfil.gerente}">
							<li><a href="/projeto/novo">Novo</a></li>
						</c:if>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">Tarefa
					<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/tarefa">Listar</a></li>
						<li><a href="/tarefa/novo">Nova</a></li>
					</ul>
				</li>
			</c:if>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${empty usuarioLogado}">
				<li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</c:if>
			<c:if test="${not empty usuarioLogado}">
				<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${usuarioLogado.nome}</a></li>
			</c:if>
		</ul>
	</div>
</nav>
