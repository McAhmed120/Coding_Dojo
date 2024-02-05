<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New ninja</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container p-5"><form:form class="col-6 rounded-3 bg-dark text-light p-5" action="/ninja/processNinja" method="post" modelAttribute="ninja">
	    <h1 class="text-primary">New Ninja</h1>
	    <div class="p-3">
	        <form:label path="dojo">Dojo :</form:label>
	        
	        <form:select path="dojo">
	        <c:forEach items="${allDojos}" var="one" >
	        <option value="${one.id }">${one.name }</option>
	        </c:forEach>
	        </form:select>
	        <form:errors class="row text-danger" path="dojo"/>
	    </div>
	    <div class="p-3">
	        <form:label path="firstName">First Name :</form:label>
	        <form:input class="col-6" path="firstName"/>
	        <form:errors class="row text-danger" path="firstName"/>
	    </div> 
	    <div class="p-3">
	        <form:label path="lastName">Last Name :</form:label>
	        <form:input class="col-6" path="lastName"/>
	        <form:errors class="row text-danger" path="lastName"/>
	    </div>
	    <div class="p-3">
	        <form:label path="age">Age :</form:label>
	        <form:input class="col-6" path="age"/>
	        <form:errors class="row text-danger" path="age"/>
	    </div>  
	    <input class="col-4 btn btn-success m-3" type="submit" value="Create"/>
	</form:form> </div>
	
	
</body>
</html>