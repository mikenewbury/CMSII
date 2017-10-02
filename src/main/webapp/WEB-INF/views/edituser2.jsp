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
			<h1>User Details</h1>
			<p>${message}</p>
			<hr/>			
		</div>
		<c:url value="/users/save" var="submitVar"/>
		<c:url value="/users" var="cancelVar"/>
		<form:form  id="edituser-form" action="${submitVar}" modelAttribute="user">
			
			<form:hidden path="id"/>
			<div class="row">
				<div class="col-lg-12">
					<div class="col-lg-2 required">
						<label for="username">Username:</label>
					</div>
					<div class="col-lg-5 input-append clearfix" id="username">
						<form:input cssClass="pull-left form-control" path="name" size="50"/>											
					</div>					
					<form:errors path="name" cssClass="error"/>
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-12">
					<div class="col-lg-2 required">
						<label for="realName">Real Name:</label>
					</div>
					<div class="col-lg-5 input-append clearfix " id="realName">
						<form:input cssClass="pull-left form-control" path="realName" size="50"/>											
					</div>					
					<form:errors path="realName" cssClass="error"/>	
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-12">
					<div class="col-lg-2 required">
						<label for="email">Email:</label>
					</div>
					<div class="col-lg-5 input-append clearfix" id="email">
						<form:input cssClass="pull-left form-control" path="email" size="50"/>						
					</div>
					<form:errors path="email" cssCLass="error"/>
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-12">
					<div class="col-lg-2">
						<label for="enabled">Enabled:</label>
					</div>
					<div class="col-lg-2 clearfix" id="enabled">
						<form:checkbox cssClass="pull-left" path="enabled"/>
					</div>
				 </div>
			</div>
								
			<div class="row">
				<div class="col-lg-12">
					<div class="col-lg-2">			
						<label for="password">Password:</label>
					</div>
					<div class="col-lg-5 input-append clearfix" id="password">
						<form:input cssClass="pull-left form-control" path="password" size="50"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="col-lg-2">			
						<label for="groups">Groups:</label>
					</div>
					<div class="col-lg-5 input-append clearfix" id="groups">						
						<form:textarea cssClass="pull-left form-control" path="groupsAsString" rows="2" cols="40" readonly="true"/>											
					</div>
					<c:if test="${user.id != null}">
						<div class="col-lg-2">	
							<span style="float: left">						
								<a class="btn btn-default fixed-width" href="<spring:url value="/usergroups/${user.id}"/>" role="button">Edit Groups</a>							
							</span>
						</div>
					</c:if>	
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="col-lg-2">			
						<label for="roles">Roles:</label>
					</div>
					<div class="col-lg-5 input-append clearfix" id="roles">						
						<form:textarea cssClass="pull-left form-control" path="rolesAsString" rows="2" cols="40" readonly="true"/>										
					</div>
					<c:if test="${user.id != null}">
						<div class="col-lg-2">	
							<span style="float: left">													
								<a class="btn btn-default fixed-width" href="<spring:url value="/userroles/${user.id}"/>" role="button"> Edit Roles	</a>
							</span>
						</div>
					</c:if>
					
				</div>
			</div>
			<sec:csrfInput/>
			<hr/>			
			<a class="btn btn-primary" href="${cancelVar}">Back</a>
			<button type="submit" id="btn-save" class="btn btn-primary">Save</button>
		</form:form>
	</div>
</body>
</html>