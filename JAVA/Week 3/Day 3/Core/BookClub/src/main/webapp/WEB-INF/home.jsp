
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
<div class="container p-5 mt-5">
<div class="d-flex justify-content-between align-items-center">
	<h1 class="text-center m-3 p-3"> Welcome , ${user.userName} !</h1>
	<form action="/logout" method="POST" class="text-center" ><input class="btn btn-outline-danger" type="submit" value="Logout" /></form>
</div>
<div class="d-flex justify-content-between align-items-center">
	<p class="text-center m-3 p-3">Books from everyone's shelves:</p>
	<a class="btn btn-outline-dark " href="/books/new">+ Add Book</a>
</div>
	<table class="table table-dark table-striped text-center">
		<thead >
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted by</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allBooks }" var="oneBook">
				<tr>
					<td>${oneBook.id}</td>
					<td><a class="text-light" href='/books/${oneBook.id }'> ${oneBook.title}</a></td>
					<td>${oneBook.author}</td>
					<td>${oneBook.user.userName }</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
</div>
</body>
</html>