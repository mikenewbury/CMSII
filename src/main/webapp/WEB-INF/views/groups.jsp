<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collections Management System - Groups</title>

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
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="row">
			<h1>Users</h1>
			<div class="row">
				
				<div class="col col-md-4">
					
						<a class="btn btn-default" href="<spring:url value="/groups/new"/>" role="button">Add Group
						<span class="glyphicon glyphicon-plus"></span>					
						</a>
						
				</div>
			</div>
			<table id="groups-table" class="table">
				<thead>
					<tr>
						<th>Group Name</th>						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.content}" var="group">
						<tr>
							<td><a href="<spring:url value="/groups/${group.id}"/>">${group.name}</a></td>
							<td>
								<c:if test="${group.deletable}">
									<a class="btn btn-default" href="<spring:url value="/groups/delete/${group.id}"/>" role="button">
										<span class="glyphicon glyphicon-remove"></span>					
									</a>	
								</c:if>
														
							
							</td>
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
					<li class="page-item"><a href="<spring:url value="/groups?page=0"/>">First</a></li>
					<li class="page-item"><a href="<spring:url value="/groups?page=${page.number - 1}"/>">Previous</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled"><a href="#">First</a></li>
					<li class="page-item disabled"><a href="#">Previous</a></li>
				</c:otherwise>
				</c:choose>
								
				<c:choose>
				<c:when test="${page.number < pages-1}" >
					<li class="page-item"><a href="<spring:url value="/groups?page=${page.number + 1}"/>">Next</a></li>
					<li class="page-item"><a href="<spring:url value="/groups?page=${pages - 1}"/>">Last</a></li>
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
</body>
</html>