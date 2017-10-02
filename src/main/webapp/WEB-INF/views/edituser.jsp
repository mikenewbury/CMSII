<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collections Management System Edit User</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
	type="text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="row">
			<h1>Edit User Details</h1>
		</div>
		<c:url value="/users/save" var="submitVar"/>
		<c:url value="/users" var="cancelVar"/>
		<form:form  id="edituser-form" action="${submitVar}" modelAttribute="user">
			
			<form:hidden path="id"/>
			<div class="form-group">			
				<label for="username">Username</label>
				<div class="input-append clearfix" id="username">
					<form:input cssClass="pull-left" path="name"/>						
				</div>
			</div>
								
			<div class="form-group">
				<label for="realName">Real Name</label>
				<div class="input-append clearfix" id="realName">
					<form:input cssClass="pull-left" path="realName"/>						
				</div>
			</div>
			
			<div class="form-group">
				<label for="email">Email</label>
				<div class="input-append clearfix" id="email">
					<form:input cssClass="pull-left" path="email"/>
				</div>
			</div><div class="form-group">		
				<label for="enabled">Enabled</label>
				<div class="input-append clearfix" id="enabled">
					<form:checkbox cssClass="pull-left" path="enabled"/>
				</div>
			</div>					
			<div class="form-group">
				<label for="password">Password</label>
				<div class="input-append clearfix" id="password">
					<form:input cssClass="pull-left" path="password"/>
				</div>
			</div>
			<sec:csrfInput/>
						
			<a class="btn btn-primary" href="${cancelVar}">Cancel</a>
			<button type="submit" id="btn-save" class="btn btn-primary">Save</button>
		</form:form>
	</div>
</body>
</html>