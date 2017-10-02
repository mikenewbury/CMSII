<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collections Management System Edit Group</title>

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
			<h1>Group Details</h1>
			<p>${message}</p>
			<hr/>			
		</div>
		<c:url value="/groups/save" var="submitVar"/>
		<c:url value="/groups" var="cancelVar"/>
		<form:form  id="editgroup-form" action="${submitVar}" modelAttribute="group">
			
			<form:hidden path="id"/>
			<div class="row">
				<div class="col-lg-12">
					<div class="col-lg-2 required">
						<label for="name">Group Name:</label>
					</div>
					<div class="col-lg-5 input-append clearfix" id="name">
						<form:input cssClass="pull-left form-control" path="name" size="50"/>											
					</div>					
					<form:errors path="name" cssClass="error"/>
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
					<c:if test="${group.id != null}">
						<div class="col-lg-2">	
							<span style="float: left">													
								<a class="btn btn-default fixed-width" href="<spring:url value="/grouproles/${group.id}"/>" role="button"> Edit Roles	</a>
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