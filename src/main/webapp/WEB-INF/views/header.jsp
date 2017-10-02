<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="<spring:url value="/resources/js/global.js"/>"></script>
	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<a href="<spring:url value="/"/>" class="navbar-brand">Collections Management System</a>
			</div>
			<ul class="nav navbar-nav">			
				<sec:authorize access="authenticated" var="authenticated"/>
				<c:choose>				
					<c:when test="${authenticated}">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li class="dropdown">
							<a href="<spring:url value="/admin/"/>" data-toggle="dropdown" class="dropdown-toggle">Administration <b class="caret"></b></a>
						
							 <ul class="dropdown-menu">

                    			<li><a href="<spring:url value="/users"/>">Manage Users</a></li>
                    			<li><a href="<spring:url value="/groups"/>">Manage Groups</a></li>
                    			<li><a href="#">Manage Functions</a></li>
			                    <li><a href="#">Manage Constraints</a></li>
			                    <li><a href="#">Change Password</a></li>
			                    <li><a href="#">Session Defaults</a></li>

                             </ul>
						</li>
						</sec:authorize>
						<li class="dropdown">
							<a href="<spring:url value="/catalogue/"/>" data-toggle="dropdown" class="dropdown-toggle">Catalogues <b class="caret"></b></a>
						
							 <ul class="dropdown-menu">

								<!-- make objects further drop down menu -->
                    			<li><a href="#">Objects</a></li>                    			
                    			<li><a href="#">MARC</a></li>
			                    
                             </ul>
						</li>
						<li class="dropdown">
							<a href="<spring:url value="/directories/"/>" data-toggle="dropdown" class="dropdown-toggle">Directories <b class="caret"></b></a>
						
							 <ul class="dropdown-menu">

                    			<li><a href=<spring:url value="/locations/"/>>Locations 1</a></li>
                    			<li><a href=<spring:url value="${locationsUrl}"/>>Locations 2</a></li>
                    			<li><a href="#">Names</a></li>
			                    <li><a href="#">Thesaurus Terms</a></li>
			                    <li><a href="#">Sources</a></li>
			                    <li><a href="#">Authority Lists</a></li>
			                    <li><a href="#">Reference Types</a></li>
			                    <li><a href="#">Media</a></li>
								
                             </ul>
						</li>

						<li class="dropdown">
							<a href="<spring:url value="/operations/"/>" data-toggle="dropdown" class="dropdown-toggle">Operations <b class="caret"></b></a>
						
							 <ul class="dropdown-menu">

                    			<li><a href="#">Inventory Check</a></li>
                    			<li><a href="#">Condition Check</a></li>
			                    <li><a href="#">Movements</a></li>
			                    <li><a href="#">Exhibitions/Loans</a></li>
			                    <li><a href="#">Entry Records</a></li>
			                    <li><a href="#">Exit Records</a></li>
			                    <li><a href="#">SPECTRUM Import</a></li>
			                    <li><a href="#">Thesaurus Import</a></li>
								<li><a href="#">Offline</a></li>
								
                             </ul>
						</li>
						
						<li>
							<p class="navbar-text">
								Welcome
								<sec:authentication property="name"/>
								<a id="logout" href="#">Logout</a>
							</p>
							<form id="logout-form" action="<c:url value="/logout"/>" method="POST">
								<sec:csrfInput/>
							</form>
						</li>
					</c:when>
					<c:otherwise>
						<li><a href="<spring:url value="/login/"/>">Sign In</a></li>						
					</c:otherwise>						
				</c:choose>						
			</ul>
		</div>
	</nav>