<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">


			<p class="lead">Product Inventory</p>
		</div>
		<table id="tableview" class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Proto</th>
					<th>Product Name</th>
					<th>Category</th>
					<th>Condition</th>
					<th>Price</th>
					<th>Details</th>
				
				</tr>
			</thead>
            <c:forEach items="${products}" var="product">
                <tr>
                 
                    <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="test" style="width:100%"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} USD </td>
                    <td><a href="<spring:url value="/product/viewproduct/${product.productId}" />">
                    <span class="glyphicon glyphicon-info-sign"></span></a></td>
                  
                   
                </tr>
            </c:forEach>
		</table>
		<%@ include file="/WEB-INF/views/template/footer.jsp"%>
</div>
</div>


<