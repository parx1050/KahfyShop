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
	
		<form:form action="saveMember" modelAttribute="member" method="POST">
		
					<!-- need to associate this data with customer id -->
			<form:hidden path="memberId" />
		
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/coffee_shop/products">Back to List</a>
		</p>
	
	</div>

</body>

</html>










