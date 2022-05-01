<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty alerta}">
	<div class="alert alert-warning">
		<strong>${alerta}</strong>
	</div>
</c:if>

<c:if test="${not empty mensagem}">
	<div class="alert alert-success">
		<strong>${mensagem}</strong>
	</div>
</c:if>