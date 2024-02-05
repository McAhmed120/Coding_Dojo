<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container p-5"><form:form class="col-6 rounded-3 text-light bg-dark p-5" action="/dojo/processDojo" method="post" modelAttribute="dojo">
	    <h1 class="text-primary">New Dojo</h1>
	    <div class="p-3">
	        <form:label path="name">Name :</form:label>
	        <form:input class="col-6" path="name"/>
	        <form:errors class="row text-danger" path="name"/>
	    </div>   
	    <input class="col-4 btn btn-success m-3" type="submit" value="Create"/>
	</form:form> </div>
	
	
</body>
</html>