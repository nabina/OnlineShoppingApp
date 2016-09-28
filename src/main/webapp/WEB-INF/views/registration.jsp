<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Registration</h1>
			<p class="lead">fill The below Information</p>
		</div>

		<form:form action="" method="post" commandName="customer">

			<div class="form-group">
				<label for="userName">User Name <span style="color:red;">*</span></label>
				<form:input path="username" id="userName" class="form-control" />
				<form:errors path="username" style="color:#ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="firstName">First Name <span style="color:red;">*</span></label>
				<form:input path="firstName" id="firstName" class="form-control" />
				<form:errors path="firstName" style="color:#ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="lastName">Last Name <span style="color:red;">*</span></label>
				<form:input path="lastName" id="lastName" class="form-control" />
				<form:errors path="lastName" style="color:#ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="email">Email <span style="color:red;">*</span></label>
				<form:input path="email" id="email" class="form-control" />
				<form:errors path="email" style="color:#ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="phone">Phone no. <span style="color:red;">*</span></label>
				<form:input path="phone" id="phone" class="form-control" />
				<form:errors path="phone" style="color:#ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="password">Password <span style="color:red;">*</span></label>
				<form:password path="password" id="password" class="form-control" />
				<form:errors path="password" style="color:#ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="confirmPassword">Confirm password <span style="color:red;">*</span></label>
				<form:password path="confirmPassword" id="confirmPassword" class="form-control" />
				<form:errors path="confirmPassword" style="color:#ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="city">City <span style="color:red;">*</span></label>
				<form:input path="address.city" id="city" class="form-control" />
				<form:errors path="address.city" style="color:#ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="zipCode">Zip code <span style="color:red;">*</span></label>
				<form:input path="address.zipCode" id="zipCode" class="form-control" />
				<form:errors path="address.zipCode" style="color:#ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="state">State <span style="color:red;">*</span></label>
				<form:input path="address.state" id="state" class="form-control" />
				<form:errors path="address.state" style="color:#ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="country">Country <span style="color:red;">*</span></label>
				<form:input path="address.country" id="country" class="form-control" />
				<form:errors path="address.country" style="color:#ff0000;" />
			</div>


			

			<input type="submit" class="btn btn-primary btnWidth120"/>
		</form:form>


	</div>
	<%@ include file="/WEB-INF/views/template/footer.jsp"%>
</div>

</div>
