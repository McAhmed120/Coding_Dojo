<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container p-5">
	<h1 class="p-3">Save Travels</h1>
	<table class="table table-striped table-dark text-light text-center">
		<thead>
			<tr>
				<th scope="col">Expense</th>
				<th scope="col">Vendor</th>
				<th scope="col">Amount</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allExpenses}" var="one" >
				<tr>
					<td scope="row" ><a href="expenses/${one.id}">${one.expenseName}</a></td>
					<td>${one.vendor}</td>
					<td>$ ${one.amount}</td>
					<td class="d-flex justify-content-evenly"><a class="btn btn-warning" href='expenses/edit/${one.id}'>Edit</a>
					<form  action="/expenses/${one.id}" method="post">
								<input type="hidden" name="_method" value="delete"> 
								<input class="btn btn-danger"  type="submit" value="Delete"></form></td>
				</tr>
			</c:forEach>
			</tbody>
	</table>
	<h1 class="p-3">Add an expense :</h1>
		<form:form class="col-6 border rounded-4 border-dark text-end p-5" action="/expenses/processExpense" method="post" modelAttribute="expense">
	    <div class="p-3">
	        <form:label path="expenseName">Expense Name :</form:label>
	        <form:input class="col-6" path="expenseName"/>
	        <form:errors class="row text-danger" path="expenseName"/>
	    </div>
	    <div class="p-3">
	        <form:label path="vendor">Vendor :</form:label>
	        <form:input class="col-6" path="vendor"/>
	        <form:errors class="row text-danger" path="vendor"/>
	    </div>
	    <div class="p-3">
	        <form:label path="amount">Amount :</form:label>
	        <form:input class="col-6" type="number" step="0.01"  path="amount"/>
	        <form:errors class="row text-danger" path="amount"/>
	    </div>
	    <div class="p-3 ">
	        <form:label path="description">Description :</form:label>
	        <form:input class="col-6"  path="description"/>
	        <form:errors class="row text-danger " path="description"/>     
	    </div>    
	    <input class="col-4 btn btn-success m-3" type="submit" value="Submit"/>
	</form:form> 
		
	
	
</div>
</body>
</html>