
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>One Book</title>
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
	<h1 class="text-uppercase text-center m-3 p-3 ">${book.title}</h1>
	<a href="/books" class="btn btn-outline-dark">Back to shelves</a>
</div>
<h3 class="m-3"><span class="text-capitalize text-primary" >${book.user.userName }</span> read <span class="text-success text-capitalize text-opacity-50">${book.title }</span> by <span class="text-capitalize text-danger">${book.author }</span></h3>
<p>Here are ${book.user.userName }'s thoughts:</p>
<div class="border-top border-bottom border-info p-5 m-3" >
${book.thoughts }
</div>
<c:if test="${user.userName.equals(book.user.userName)}">
<div class="d-flex justify-content-end align-items-center gap-3 m-3">
	<a href="/books/${book.id }/edit" class="col-2 btn btn-warning">Edit</a>
	<form class="col-2" action="/delete/${book.id}" method="POST"><input type="hidden" name="_method" value="delete"><input type="submit" value="Remove" class="col-11 btn btn-outline-danger" /></form>
</div>
</c:if>
<c:if test="${!user.userName.equals(book.user.userName)}">
<div class="d-flex justify-content-end align-items-center gap-3 m-3">
	<a href="/books/${book.id }/edit" class="col-2 btn btn-warning disabled">Edit</a>
	<form class="col-2" action="/delete/${book.id}" method="POST"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete" class="col-11 disabled btn btn-outline-danger" /></form>
</div>
</c:if>

</div>
</body>
</html>
