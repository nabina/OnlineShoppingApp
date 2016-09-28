<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">


			<p class="lead">Your Cart</p>
		</div>
		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Image</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
			</thead>
			<c:forEach items="${cart.getProductList().values()}" var="product">
				<tr>


					<td><img style="max-width: 150px; width: 150px; height: auto;"
						src="<c:url value="/resources/images/${product.getProductId()}.png"/>"
						alt="test" style="width: 100%" /></td>
					<td>${product.getProductName()}</td>
					<td>${product.getPrice()}USD</td>
					<td>${product.getQty()}</td>
				</tr>
			</c:forEach>
			<tr>
				<td>Total Order: ${cart.getOrderValue()}</td>
			</tr>
		</table>

		<p>
			<span style="cursor: pointer"><a
				href="<c:url value="/productlist"/>">Continue Shopping</a><span
				class="glyphicon glyphicon-shopping-cart"></span> </span>
		</p>

		<form action="<c:url value="checkout" />" method="post">
			<div style="text-align: center; font-weight: bold; font-size: large;">
				<input type="hidden" value="${product.productId}" /> <input
					type="submit"
					style="width: 400px; cursor: pointer; background-color: orange; padding: 10px; border-radius: 20px;"
					value="Place Order" />
			</div>
		</form>
		<%@ include file="/WEB-INF/views/template/footer.jsp"%>
	</div>
</div>



