<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="pagestylesheet" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>

	<div id="cart-items-div">
		<c:forEach var="p" items="${cart.getProductList().size()}">
			<div class="cart-item">
				<a href="">Product ID: <c:out value="${p.getProductId()}" /><br>
					Product Name: <c:out value="${p.getProductName()}" /></a>
			</div>
		</c:forEach>
	</div>
	<div>
	
	</div>

</body>
</html>