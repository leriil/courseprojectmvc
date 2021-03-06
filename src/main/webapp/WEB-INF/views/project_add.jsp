<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<spring:url value="/project/add" var="formUrl"/>
			<form:form action="${formUrl}" method="post" modelAttribute="project"/>

			
				<div class="form-group">
					<label for="project-name">Name</label>
					<input type="text" id="project-name" 
							class="form-control" name="name"/>
				</div>

				<div class="form-group">
					<label for="project-type">Type</label>
					<form:select path="type" items="${types}" cssClass="selectpicker"></form:select>
				</div>


					<%--<select name="type" class="selectpicker">--%>
						<%--<option></option>--%>
						<%--<option value="single">Single Year</option>--%>
						<%--<option value="multi">Multi-Year</option>--%>
					<%--</select>--%>

							
				<div class="form-group">
					<label for="sponsor-name">Sponsor Name</label>
					<form:input id="sponsor-name" cssClass="form-control" path="sponsor.name"/>
				</div>

				<div class="form-group">
					<label for="sponsor-phone">Sponsor Phone</label>
					<input id="sponsor-phone"
						   cssClass="form-control" path="sponsor.phone"/>
				</div>

				<div class="form-group">
					<label for="sponsor-email">Sponsor Phone</label>
					<input id="sponsor-email" cssClass="form-control" path="sponsor.email"/>
				</div>
			

			
				<div class="form-group">
					<label for="project-name">Description</label>
					<textarea class="form-control" rows="3"></textarea>
				</div>
				
				<div class="form-group">
					<label for="special">Special</label>
					<input id="special" name="special" type="checkbox"/>
				</div>
			
				<button type="submit" class="btn btn-default">Submit</button>
	
			</form>
			
		</div>
	</div>
</body>
</html>