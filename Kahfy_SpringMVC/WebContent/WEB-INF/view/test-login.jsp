<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Member</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-item-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Save Member</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Member</h3>
		
		<form:input path="e" placeholder="${e}"/>
		<form:input path="p" placeholder="${p}"/>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/coffee_shop/products">Back to List</a>
		</p>
	
	</div>

</body>

</html>