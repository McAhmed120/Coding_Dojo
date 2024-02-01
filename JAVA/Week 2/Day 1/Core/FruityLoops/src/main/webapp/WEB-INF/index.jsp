<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container p-5 m-5">
	<h1 class="text-dark m-5">Fruit Store</h1>
	<div class="bg-dark p-5">
		<table class="table bg-light">
		  <thead>
		    <tr >
		      <th class="border border-dark" scope="col">Name</th>
		      <th class=" border border-dark " scope="col">Price</th>
		    </tr>
		  </thead >
		  <tbody >
		  <c:forEach items="${fruits}" var="fruit">
			    <tr >
			      <td class=" border border-dark "><c:out value="${fruit.name }" /></td>
			      <td class=" border border-dark "><c:out value="${fruit.price} " /></td>
			    </tr>
			    </c:forEach>
		  </tbody>
	</table>
	</div>
</div>
</body>
</html>