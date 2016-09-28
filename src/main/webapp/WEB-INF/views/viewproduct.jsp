
<%@ include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Detail</h1>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<img
						src="<c:url value="/resources/images/${product.productId}.png"/>"
						alt="test" style="width: 100%" />
				</div>
				<div class="col-md-5">
					<h3>${product.productName}</h3>
					<p>${product.productDescription}</p>
					<p>
						<strong>Manufacturer</strong>: ${product.productManufacture}
					</p>
					<p>
						<strong>Category</strong>: ${product.productCategory}
					</p>
					<p>
						<strong>Condition</strong>: ${product.productCondition}
					</p>
					<p>
						<strong>Price</strong>: ${product.productPrice}USD
					</p>

					<p>
						<strong>Quantity</strong>: <input id="${product.productId}"
							type="text" maxlength="2" value="1" />
					</p>

					<c:choose>
						<c:when test="${product.getProductUnitInStock() > 0 }">
							<p>
								<span style="cursor: pointer"
									onclick="addToCart(${product.productId} , '${product.productName}', ${product.productPrice})">Add
									to cart <span class="glyphicon glyphicon-shopping-cart"></span>
								</span>
							</p>
						</c:when>
						<c:otherwise>
							<p>
								<span style="cursor: pointer; color: red;">Out Of
									Stock!!!</span>
							</p>
						</c:otherwise>
					</c:choose>

					<p>
						<span style="cursor: pointer"><a
							href="<c:url value="/productlist"/>">Continue Shopping</a><span
							class="glyphicon glyphicon-shopping-cart"></span> </span>
					</p>

					<p>
						<span style="cursor: pointer"><a
							href="<c:url value="/showcart"/>">Show Cart</a><span
							class="glyphicon glyphicon-shopping-cart"></span> </span>
					</p>

					<p>
						<label id="cartSuccess"> </label>
					</p>



					<br />


				</div>

			</div>
			<%@ include file="/WEB-INF/views/template/footer.jsp"%>
		</div>
	</div>

</div>




