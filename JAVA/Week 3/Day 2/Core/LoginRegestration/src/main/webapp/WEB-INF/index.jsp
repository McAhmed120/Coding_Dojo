
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1 class="m-3 p-3">Welcome!</h1>
<h3 class="m-3 p-3">Join our growing community.</h3>
<div class="bg-dark p-3 m-3">
<h1 class="m-3 p-3 text-primary">Register</h1>
	<form:form class="text-light p-3" action="/register" method="post" modelAttribute="newUser">
	    <div class="p-3">
	        <form:label class="col-2" path="userName">User Name :</form:label>
	        <form:input class="col-6" path="userName"/>
	        <form:errors class="row text-danger" path="userName"/>
	    </div> 
	    <div class="p-3">
	        <form:label class="col-2" path="email">Email :</form:label>
	        <form:input class="col-6" path="email"/>
	        <form:errors class="row text-danger" path="email"/>
	    </div>
	    <div class="p-3">
	        <form:label class="col-2" path="password">Password :</form:label>
	        <form:input type="password" class="col-6" path="password"/>
	        <form:errors class="row text-danger" path="password"/>
	    </div>
	    <div class="p-3">
	        <form:label class="col-2" path="confirm">Confirm PW :</form:label>
	        <form:input type="password" class="col-6" path="confirm"/>
	        <form:errors class="row text-danger" path="confirm"/>
	    </div>  
	    <input class="col-2 btn btn-success m-3" type="submit" value="Register"/>
	</form:form>
</div>
<div class="bg-dark p-3 m-3">
<h1 class="m-3 p-3 text-primary" >Login</h1>
<form:form class="text-light p-3" action="/login" method="post" modelAttribute="newLogin">
	    <div class="p-3">
	        <form:label class="col-2" path="email">Email :</form:label>
	        <form:input class="col-6" path="email"/>
	        <form:errors class="row text-danger" path="email"/>
	    </div>
	    <div class="p-3">
	        <form:label class="col-2" path="password">Password :</form:label>
	        <form:input type="password" class="col-6" path="password"/>
	        <form:errors class="row text-danger" path="password"/>
	    </div>
	    <input class="col-2 btn btn-success m-3" type="submit" value="Submit"/>
	</form:form>

</div>
</div>
</body>
</html>