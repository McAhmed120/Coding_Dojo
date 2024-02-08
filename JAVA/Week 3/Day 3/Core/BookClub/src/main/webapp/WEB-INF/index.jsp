
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
<h1 class="m-3 p-3" style="color:Green;">Book Club</h1>
<h3 class="m-3 p-3">A place for friends to share thoughts on books</h3>
<div class="row">

<div class="col bg-dark p-3 m-3">
<h1 class="m-3 p-3 text-success">Register</h1>
	<form:form class="text-light p-3" action="/register" method="post" modelAttribute="newUser">
	    <div class="p-3">
	        <form:label class="col-4" path="userName">User Name :</form:label>
	        <form:input class="col-6" path="userName"/>
	        <form:errors class="row text-danger" path="userName"/>
	    </div> 
	    <div class="p-3">
	        <form:label class="col-4" path="email">Email :</form:label>
	        <form:input class="col-6" path="email"/>
	        <form:errors class="row text-danger" path="email"/>
	    </div>
	    <div class="p-3">
	        <form:label class="col-4" path="password">Password :</form:label>
	        <form:input type="password" class="col-6" path="password"/>
	        <form:errors class="row text-danger" path="password"/>
	    </div>
	    <div class="p-3">
	        <form:label class="col-4" path="confirm">Confirm PW :</form:label>
	        <form:input type="password" class="col-6" path="confirm"/>
	        <form:errors class="row text-danger" path="confirm"/>
	    </div>  
	    <input class="col-4 btn btn-success m-3" type="submit" value="Register"/>
	</form:form>
</div>
<div class="col bg-dark p-3 m-3">
<h1 class="m-3 p-3 text-success" >Login</h1>
<form:form class="text-light p-3" action="/login" method="post" modelAttribute="newLogin">
	    <div class="p-3">
	        <form:label class="col-4" path="email">Email :</form:label>
	        <form:input  class="col-6" path="email"/>
	        <form:errors class="row text-danger" path="email"/>
	    </div>
	    <div class="p-3">
	        <form:label class="col-4" path="password">Password :</form:label>
	        <form:input type="password" class="col-6" path="password"/>
	        <form:errors class="row text-danger" path="password"/>
	    </div>
	    <input class="col-4 btn btn-success m-3" type="submit" value="Login"/>
	</form:form>

</div>
</div>
</div>
</body>
</html>