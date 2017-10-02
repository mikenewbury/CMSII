<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collections Management System</title>

<link rel="stylesheet" href="<spring:url value="/resources/css/cms.css"/>" >
	
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme 

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
-->
<!-- Latest Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
	type="text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<div class="container img-backed">
		<div class="row">							
			<h1 align="center">Welcome to The Collections Management System.</h1>
			<hr>
		</div>
		<div class="row">
		<br/>
        <div class="col-md-4 col-md-offset-4">
            <form action="" class="search-form">
                <div class="form-group has-feedback">
            		<label for="search" class="sr-only">Search</label>
            		<input type="text" class="form-control" name="search" id="search" placeholder="Search CMS">
              		<span class="glyphicon glyphicon-search form-control-feedback"></span>
            	</div>
            </form>
        </div>
    </div>
					
	
	</div>
	
</body>
</html>