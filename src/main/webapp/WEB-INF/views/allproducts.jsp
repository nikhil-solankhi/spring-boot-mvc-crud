<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of products</title>
<link href="css/custom.css" rel="stylesheet">
</head>


<body>
<div class="container">
	<h2>LIST OF PRODUCTS</h2>
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>DETAILS</th>
			<th>PRICE</th>
			<th>DISCOUNT</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>
		<c:forEach items="${requestScope.products}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.details}</td>
				<td>${product.price}</td>
				<td>${product.discount}</td>
				<td>
				<button class="btn-edit">
				<a href="<c:url value='/edit/${product.id}' />">Edit</a>
				</button>
				
				</td>
				<td>
				<button class="btn-delete">
				<a href="<c:url value='/delete/${product.id}' />">Delete</a>
				</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<button class="btn-add">
		<a href="<c:url value='/new' />">Add New product</a>
	</button>
</div>
</body>
</html>