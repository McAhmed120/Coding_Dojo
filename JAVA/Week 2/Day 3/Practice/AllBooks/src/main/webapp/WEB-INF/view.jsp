<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Reading Books</title>
        <!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
<body>
<div class="container m-5 p-5">
	<div class="card">
	  <div class="card-header">Details</div>
	  <div class="card-body p-5">
	    <h1 class="card-title">${book.title }</h1>
	    <p class="card-text">Description :${book.description }</p>
	    <p class="card-text">Language : ${book.language }</p>
	    <p class="card-text">Number of Pages : ${book.numberOfPages }</p>
	  </div>
	</div>
</div>
</body>
</html>