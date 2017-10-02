<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collections Management System Edit User</title>

<link rel="stylesheet" href="<spring:url value="/resources/css/cms.css"/>" >
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
			<h2>Edit Roles for user <i>${user.username}</i></h2>
			<hr/>
		</div>
		<c:url value="/userroles" var="submitVar"/>
		<c:url value="/users/${user.id}" var="cancelVar"/>
		<form:form  id="edituserrole-form" action="${submitVar}" modelAttribute="user">
			
			<form:hidden path="id"/>
			<div class="row">
				<div class="col-lg-12">
					<div class="col-lg-1">			
						<label>Roles:</label>
					</div>
					<div class="col-lg-4">
						<form:select cssClass="pull-left form-control" multiple="true" items="${availableRoles }" path="roles" itemLabel="name" itemValue="id" size="20"/>
					</div>
					
				</div>
			</div>			
			
			<sec:csrfInput/>
			<hr/>			
			<a class="btn btn-primary" href="${cancelVar}">Cancel</a>
			<button type="submit" id="btn-save" class="btn btn-primary">Save</button>
		</form:form>
	</div>
</body>
</html>