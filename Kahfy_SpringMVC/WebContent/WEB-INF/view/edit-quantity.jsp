<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<title>Edit Quantity</title>

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
	href="${pageContext.request.contextPath}/resources/css/cart-style.css" />
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
			<h1 id="cartTitle">Edit Quantity</h1>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<div class="cartContainer">
				<div class="cartInfo">
						<div class="cartDivider"></div>
						<div class="eachItemDiv">
							<div class="itemDivider cartNandD">
								<h2 class="cartName">${product.name}</h2>
								<h4 class="cartDesc">${product.description}</h4>
							</div>
							
							<c:set var="productPrice">
							<fmt:formatNumber type="number" minFractionDigits="2"
								maxFractionDigits="2"
								value="${product.price}" />
						</c:set>

							<div class="itemDivider">
								<h4 class="cartSubtotal">Price: $${productPrice}</h4>
								<h4 class="cartSubtotal">Rewards: ${product.rewardsWorth}</h4>
							</div>

							<div class="itemDivider cartQandA">
								<form action="updateQuantity">
									<input type="hidden" name="theProductId" value="${product.productId}">
									<input type="text" autofocus id="quantityInput" value="${cartItem.quantity}" name="quantity">
									<button class="checkoutButton" id="editQButton" type="submit"><h4>Update</h4></button>
								</form>
							</div>
						</div>

				</div>
			</div>

		</div>

	</div>


</body>

</html>