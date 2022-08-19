<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Members</title>
	
	<!-- reference our style sheet -->
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
				<li class="nav-item"><a class="nav-link" href="member">Members</a></li>
				<li class="nav-item"><a class="nav-link" href="products">Products</a></li>
			</ul>
		</nav>
	</div>

	<div id="wrapper">
		<div id="header">
			<h2>Members of the Coffee Shop</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
				<!-- put new button: Add Member -->
		<input type="button" value="Add Member"
				onclick="window.location.href='showFormForAddMember'; return false;"
				class="add-button"/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Rewards</th>
					<th>Update</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempMember" items="${members}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/kahfy_products/showFormForUpdateMember">
						<c:param name="memberId" value="${tempMember.memberId}" />
					</c:url>
					
										<!-- construct an "update" link with customer id -->
					<c:url var="deleteLink" value="/kahfy_products/deleteMember">
						<c:param name="memberId" value="${tempMember.memberId}" />
					</c:url>	
				
					<tr>
						<td> ${tempMember.name} </td>
						<td> ${tempMember.email} </td>
						<td> ${tempMember.rewards} </td>
						
						<td>
						<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this member?'))) return false">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









