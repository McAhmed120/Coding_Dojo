
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Book</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container p-5 mt-5">
<div class="d-flex justify-content-between align-items-center">
	<h1 class="text-center m-3 p-3">Add a Book to Your Shelf!</h1>
	<a href="/books" class="btn btn-outline-dark">Back to shelves</a>
</div>
<div class="border border-2 shadow p-3 m-3">
<form:form class="p-3" action="/processBook" method="post" modelAttribute="book">
		<form:errors class="text-danger" path="*"/>
	    <div class="p-3">
	        <form:label class="col-4" path="title">Title :</form:label>
	        <form:input class="col-6" path="title"/>
	    </div>
	    <div class="p-3">
	        <form:label class="col-4" path="author">Author :</form:label>
	        <form:input class="col-6" path="author"/>
	    </div>
	    <div class="p-3">
	        <form:label class="col-4" path="thoughts">My thoughts :</form:label>
	        <form:input class="col-6" path="thoughts"/>

	    </div>
	    <input class="col-11 btn btn-outline-success m-3" type="submit" value="Submit"/>
	</form:form>

</div>
</div>
</body>
</html>