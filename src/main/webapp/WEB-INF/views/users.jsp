<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collections Management System - Users</title>

<link rel="stylesheet"
	href="<spring:url value="/resources/css/cms.css"/>" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/global.css"/>" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/datepicker.css"/>" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-multiselect.css"/>" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Latest Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
	type="text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-datepicker.js"/>"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-multiselect.js"/>"></script>
<script src="<spring:url value="/resources/js/appointments.js"/>"></script>
<script>
	var root = "${pageContext.request.contextPath}";
</script>
</head>
<body>
	<jsp:include page="header-min.jsp"/>
	<div class="container">
		<div class="row">
			<h1>Users</h1>
			<div class="row">
				
				<div class="col col-md-1">
					
						<a class="btn btn-default" href="<spring:url value="/users/new"/>" role="button">Add User
						<!-- 
						<span class="glyphicon glyphicon-plus"></span>
						-->					
						</a>
						
				</div>
				&nbsp;
				<div class="col col-md-1">
					
						<a class="btn btn-default" href="<spring:url value="/users/close"/>" role="button">Close</a>
						
				</div>
			</div>
			<table id="users-table" class="table">
				<thead>
					<tr>
						<th>Username</th>
						<th>Real Name</th>
						<th>Email</th>
						<th>Locked</th>						
						<th>Enabled</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.content}" var="user">
						<tr>
							<td><a href="<spring:url value="/users/${user.id}"/>">${user.username}</a></td>
							<td>${user.realName}</td>
							<td>${user.email}</td>							
							<td>${!user.accountNonLocked}</td>	
							<td>${user.enabled}</td>								
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
			
			<div align="left">
			Page ${page.number+1} of ${pages}
			</div>
			
			<div align="center">
			<nav aria-label="Page Controls">
			
			<ul class="pagination">
				<c:choose>
				<c:when test="${page.number > 0}">				
					<li class="page-item"><a href="<spring:url value="/users?page=0"/>">First</a></li>
					<li class="page-item"><a href="<spring:url value="/users?page=${page.number - 1}"/>">Previous</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled"><a href="#">First</a></li>
					<li class="page-item disabled"><a href="#">Previous</a></li>
				</c:otherwise>
				</c:choose>
								
				<c:choose>
				<c:when test="${page.number < pages-1}" >
					<li class="page-item"><a href="<spring:url value="/users?page=${page.number + 1}"/>">Next</a></li>
					<li class="page-item"><a href="<spring:url value="/users?page=${pages - 1}"/>">Last</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled"><a href="#">Next</a></li>
					<li class="page-item disabled"><a href="#">Last</a></li>
				</c:otherwise>
				</c:choose>
			</ul>
			</nav>
			</div>
			
			</div>
		</div>
	</div>
	
	<div id="add-user-form" class="modal fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<c:url var="saveUser" value="/users/save"/>
			<form:form id="user-form" action="${saveUser}" modelAttribute="user"  >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel"></h4>
					</div>
					<div class="modal-body">
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
						</div>
						<div class="form-group">
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
					</div>
					<div class="modal-footer">
						<button type="button" id="btn-close" class="btn btn-default"
							data-dismiss="modal">Close</button>
						<button type="submit" id="btn-save" class="btn btn-primary">Save
							Changes</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	
</body>
</html>