<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-around align-items-center p-5 m-5">
	<h1 class="">Edit Expense</h1>
	<a class="btn btn-dark" href="/expenses">Go Back</a>
	</div>
	<div class="row">
	<div class="col"></div>
	<form:form class="col-6 rounded-5 bg-dark text-light text-end p-5 m-5"  action="/expenses/update/${expense.id }" method="post" modelAttribute="expense">
	<input type="hidden" name="_method" value="put">
	    <div class="p-3 ">
	        <form:label path="expenseName">Expense Name :</form:label>
	        <form:input class="col-6" path="expenseName"/>
	        <form:errors class="row text-danger "  path="expenseName"/>
	    </div>
	    <div class="p-3 ">
	        <form:label path="vendor">Vendor :</form:label>
	        <form:input class="col-6" path="vendor"/>
	        <form:errors class="row text-danger "  path="vendor"/>
	    </div>
	    <div class="p-3 ">
	        <form:label path="amount">Amount :</form:label>
	        <form:input class="col-6" type="number" step="0.01" path="amount"/>
	        <form:errors class="row text-danger "  path="amount"/>
	    </div>
	    <div class="p-3 ">
	        <form:label path="description">Description :</form:label>
	        <form:input class="col-6"  path="description"/>
	        <form:errors class="row text-danger "  path="description"/>     
	    </div>    
	    <input class="btn btn-lg btn-warning m-3" type="submit" value="Submit"/>
	</form:form>   
	<div class="col"></div>
	</div>
</div>
</body>
</html>