<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<p class="lead">Your Order has been completed!</p>
		</div>

		<c:choose>
			<c:when test="${not empty cart }">
				<div style="text-align: center;">
					<h2>Total Items: ${cart.getProductList().size() }</h2>
					<br>
					<h2>Total Value: ${cart.getOrderValue()}</h2>
					<br> <br>
					<h3>We will contact you as soon as your items are shipped!</h3>
					<br> <br> <a href="<c:url value="/" />">Go to home
						page.</a>
				</div>
			</c:when>
			<c:otherwise>
				<div style="text-align: center;">
					<span>Ooops!!!</span>
				</div>
			</c:otherwise>
		</c:choose>

		<%@ include file="/WEB-INF/views/template/footer.jsp"%>
	</div>
</div>



