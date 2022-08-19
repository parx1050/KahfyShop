<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kahfy - Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- JavaScript Bundle with Popper -->

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/home-style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/b2b-style.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=DM+Serif+Display&display=swap"
	rel="stylesheet">
</head>
<body>
	<div>
		<a href="http://localhost:8080/Shyu_Parker_Kahfy_SpringMVC/kahfy/home"><button type="button"
				class="api_button">
				<h4>Back to Kahfy Home</h4>
			</button></a>
	</div>
	<div id="hero">
		<h3 id="welcome">Welcome to Kahfy's B2B Page</h3>
		<h4 id="select">Select which API you would like to access:</h4>
		<div id="api_button_div">
			<a href="http://localhost:8085/api/members"><button type="button"
					class="api_button">
					<h4>Kahfy Member API</h4>
				</button></a> <a href="http://localhost:8085/api/products"><button
					type="button" class="api_button">
					<h4>Kahfy Product API</h4>
				</button></a>
		</div>
	</div>

</body>
</html>

