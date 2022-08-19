<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kahfy - Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- JavaScript Bundle with Popper -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/home-style.css" />
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" >
		<link href="https://fonts.googleapis.com/css2?family=DM+Serif+Display&display=swap" rel="stylesheet">
</head>
<body>
	<div id="header">
		<nav>
			<img id="logo-link" src="${pageContext.request.contextPath}/resources/images/Kahfy Logo, Red n:Background.png" />
			<ul id="nav-elements" class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="admin">Admin Portal</a></li>
				<li class="nav-item"><a class="nav-link" href="b2b">B2B Portal</a></li>
			</ul>
		</nav>
	</div>
	
	<div id="hero">
		<h1>Kahfy Shop</h1>
		<div id="hero-titleless">
			<h3>Welcome to the Kahfy Shop, a small e-commerce website reducing the complexity of online order systems and rewards to its simplest form.</h3>
			<div id="home-login-buttons">
				<a href="login"><button class="button home-buttons"><h2>Login or Create Account</h2></button></a>
			</div>
		</div>
	</div>
</body>
</html>

