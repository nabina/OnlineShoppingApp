<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div id="login-box" class="loginBox">
			<c:if test="${msg!=null }"> <h2 style="color:green">${msg} </h2> </c:if>
			<h2>Welcome to your profile page</h2>
			<table>
				<tr>
					<th>First Name:</th>
					<td>${customer.firstName}</td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td>${customer.lastName}</td>
				</tr>
				<tr>
					<th>Email:</th>
					<td>${customer.email}</td>
				</tr>
				<tr>
					<th>Phone:</th>
					<td>${customer.phone}</td>
				</tr>
				<tr>
					<th>Address:</th>
					<td>${customer.address.city},${customer.address.zipCode},
						${customer.address.state},${customer.address.country}</td>
				</tr>
			</table>
			
			<br/>
			<a href="changePassword" class="btn btn-primary">Change Password</a> <br /> 
		</div>
		<%@ include file="/WEB-INF/views/template/footer.jsp"%>
	</div>

</div>



