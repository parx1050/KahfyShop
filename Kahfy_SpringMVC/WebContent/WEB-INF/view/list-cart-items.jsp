<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
			<h1 id="cartTitle">Your Cart</h1>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<h3 id="memberRewards">Member Rewards: ${member.rewards}</h3>
			<h2 id="rewardNote">NOTE: Each item in your cart can be discounted with 50 rewards.</h2>
			<div class="cartContainer">
				<div class="cartInfo">
					<c:set var="totalCost" value="0" />
					<c:set var="totalRewardsApplied" value="0" />
					<c:set var="totalRewardsToEarn" value="0" />
					<c:forEach var="tempCartItem" items="${cart_items}">
						<c:set var="tempProduct" value="${tempCartItem.product}" />
						<c:set var="rewardsApplied" value="${tempCartItem.rewardsApplied}" />
						<c:set var="rewardsToEarn" value="${tempCartItem.rewardsToEarn}" />
						<c:set var="productSubtotal">
							<fmt:formatNumber type="number" minFractionDigits="2"
								maxFractionDigits="2"
								value="${tempCartItem.subtotal}" />
						</c:set>
						<c:url var="applyRewards" value="/kahfy/apply-rewards">
							<c:param name="productId" value="${tempProduct.productId}" />
						</c:url>
						<c:url var="updateQuantity"
							value="/kahfy/shopping-cart-edit-quantity">
							<c:param name="productId" value="${tempProduct.productId}" />
						</c:url>
						<c:url var="deleteProduct" value="/kahfy/shopping-cart-delete">
							<c:param name="productId" value="${tempProduct.productId}" />
						</c:url>
						<c:url var="checkout" value="/kahfy/checkout">
						</c:url>

						<div class="cartDivider"></div>
						<div class="eachItemDiv">
							<div class="itemDivider cartNandD">
								<h2 class="cartName">${tempProduct.name}</h2>
								<h4 class="cartDesc">${tempProduct.description}</h4>
								<h4 class="cartDesc">Reward Value: ${tempProduct.rewardsWorth}</h4>
							</div>

							<div class="itemDivider">
								<h4 class="cartSubtotal">Subtotal: $${productSubtotal}</h4>
								<h4 class="cartSubtotal">Rewards Applied: ${rewardsApplied}</h4>
								<h4 class="cartSubtotal">Rewards to Earn: ${rewardsToEarn}</h4>
							</div>

							<div class="itemDivider cartQandA">
								<h4 class="cartQuantity">Quantity: ${tempCartItem.quantity}</h4>
								<h4 class="cartActions">
									<a href="${applyRewards}">Apply Rewards</a> | 
									<a href="${updateQuantity}">Edit Quantity</a>
								</h4>
								<h4 class="cartActions"><a href="${deleteProduct}">Remove</a></h4>
							</div>
						</div>

						<c:set var="totalCost" value="${totalCost + productSubtotal}" />
						<c:set var="totalRewardsApplied" value="${totalRewardsApplied + rewardsApplied}" />
						<c:set var="totalRewardsToEarn" value="${totalRewardsToEarn + rewardsToEarn}" />
					</c:forEach>

					<div class="totalDivider"></div>

					<div class="totalContainer">
						<c:set var="totalCostAdjusted">
							<fmt:formatNumber type="number" minFractionDigits="2"
								maxFractionDigits="2" value="${totalCost}" />
						</c:set>
						<div class="totalHeader">
							<h2 class="totalTitle">Total:</h2>
							<h4 class="totalRewards">Total Rewards Applied: ${totalRewardsApplied}</h4>
							<h4 class="totalRewards">Total Rewards to Earn: ${totalRewardsToEarn}</h4>
						</div>
							<h2 class="totalValue">$${totalCostAdjusted}</h2>
						
						<a href="${checkout}"><button class="checkoutButton"
								type="submit">Checkout</button></a>
					</div>

				</div>
			</div>

		</div>

	</div>


</body>

</html>




