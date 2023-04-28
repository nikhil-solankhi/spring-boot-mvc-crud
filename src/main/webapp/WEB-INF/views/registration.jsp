<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product Registration Form</title>
<link href="css/custom.css" rel="stylesheet">
<style type="text/css">
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	font-family: cursive;
}
.container{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

a{
	text-decoration: none;
	color: white
}


table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 8px;
}
th{
	background-color: olive;
	color: white
}

tr:nth-child(even){background-color: #f2f2f2}
.error {
		color: #ff0000;
	}
.container-reg-btn{
	display: flex;
	justify-content: center;
}
.btn-register{
	border-radius: 5px;
	background-color: green;
	color: white;
	border: 1px solid green;
	padding: 5px
}
.btn-goback{
	border-radius: 5px;
	background-color: blue;
	color: white;
	border: 1px solid blue;
	padding: 5px
}

</style>


</head>

<body>

	<h2>Registration Form</h2>

	<form:form method="POST" modelAttribute="Product">
		<form:input type="hidden" path="id" id="id" />
		<table>
			<tr>
				<td><label for="name">Name</label></td>
				<td>:&nbsp;<form:input path="name" id="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="details">Details</label></td>
				<td>:&nbsp;<form:input path="details" id="details" /></td>
				<td><form:errors path="details" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="price">Price</label></td>
				<td>:&nbsp;<form:input path="price" id="price" /></td>
				<td><form:errors path="price" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="discount">Discount</label></td>
				<td>:&nbsp;<form:input path="discount" id="discount" /></td>
				<td><form:errors path="discount" cssClass="error" /></td>
			</tr>


		</table>

		<br />
		<br />
		<div class="container-reg-btn">
			<input class="btn-register" type="submit" value="Register" />
	</form:form>
	&nbsp;
	<button class="btn-goback">
		<a href="<c:url value='/list' />">List of All Products</a>
	</button>
	</div>

</body>
</html>