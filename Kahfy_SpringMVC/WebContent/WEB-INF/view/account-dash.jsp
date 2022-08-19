<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Products</title>

<!-- reference our style sheet -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/home-style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/account-style.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=DM+Serif+Display&display=swap"
	rel="stylesheet">

</head>

<body>
	<div id="header">
		<nav>
			<img id="logo-link"
				src="${pageContext.request.contextPath}/resources/images/Kahfy Logo, Red n:Background.png" />
			<ul id="nav-elements" class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="products">Products</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="false">Account</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="account-dash">Details</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="logout">Log Out</a>
					</div></li>
				<li class="nav-item"><a class="nav-link active"
					href="shopping-cart"><img id="cart-icon"
						src="${pageContext.request.contextPath}/resources/images/Red Cart.png"></a>
			</ul>
		</nav>
	</div>

	<div id="wrapper">
		<div id="title">
			<h1 id="productTitle">Account</h1>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<div class="accountRow"><h2 class="accountLabel">Name:</h2><h2 class="accountDetails">${loggedInMember.name}</h2></div>
			<div class="accountRow"><h2 class="accountLabel">Email:</h2><h2 class="accountDetails">${loggedInMember.email}</h2></div>
			<div class="accountRow"><h2 class="accountLabel">Rewards:</h2><h2 class="accountDetails">${loggedInMember.rewards}</h2></div>

		</div>

	</div>


</body>

</html>