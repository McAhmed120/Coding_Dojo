
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container border border-dark border-2 shadow p-5 mt-5">
	<h1 class="text-center m-3 p-3"> Welcome , ${user.name} !</h1>
	<p class="text-center m-3 p-3">This is your dashboard. Nothing to see here yet.</p>
	<form action="/logout" method="POST" class="text-center" ><input class="col-3 btn btn-lg btn-danger" type="submit" value="Logout" /></form>
</div>
</body>
</html>