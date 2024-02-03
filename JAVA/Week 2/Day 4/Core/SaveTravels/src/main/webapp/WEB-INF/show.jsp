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
	<h1 class="">Expense Details</h1>
	<a class="btn btn-dark" href="/expenses">Go Back</a>
	</div>
	<div class="row">
	<div class="col"></div>
	<div class="col-6 rounded-5 bg-dark text-light p-5 m-5">
	    <div class="row p-3 ">
	        <p class="col">Expense Name :</p>
	        <h3 class="col">${expense.expenseName}</h3> 
	    </div>
	    <div class="row p-3 ">
	        <p class="col">Vendor :</p>
	        <h3 class="col">${expense.vendor}</h3> 
	    </div>
	    <div class="row p-3 ">
	        <p class="col">Amount :</p>
	        <h3 class="col">$ ${expense.amount}</h3> 
	    </div>
	    <div class="row p-3 ">
	        <p class="col">Description :</p>
	        <h5 class="col">${expense.description}</h5>     
	    </div>    
	</div>   
	<div class="col"></div>
	</div>
</div>
</body>
</html>