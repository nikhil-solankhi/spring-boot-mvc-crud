<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Confirmation Page</title>
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

.btn-goback{
	border-radius: 5px;
	background-color: blue;
	color: white;
	border: 1px solid blue;
	padding: 5px
}
.container-success-btn{
	display: flex;
	flex-direction:column;
	justify-content: center;
}

</style>
</head>
<body>
<div class="container-success-btn">
	${success}
	<br/>
	<br/>
	<div>	Go back to	<button class="btn-goback"><a href="<c:url value='/list' />">List of All Products</a></button>
	</div>
	</div>
	
</body>

</html>