<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <script src="<c:url value="/resources/js/cart.js" />"></script>

    <title>Girls Dresses Store</title>

    <!-- Angular.JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script  type="text/javascript "src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>


    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- MaCarouselin CSS -->
    <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">

    <!-- Main CSS -->
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">


   <link  rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" /> 
 	<script>
		var contextPath = "${pageContext.request.contextPath}";
	</script> 
	
  <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
  <script src="<c:url value="/resources/js/bootstrap-toggle.min.js" />"></script> 
<%--   <script src="<c:url value="/resources/js/jquery-3.1.1.js" />"></script>  --%>
  <script>

  
    	$(document).ready(function(){
    		var sCondition="${param.searchCondition}";
    	    $('#tableview').DataTable({
    	    		 "lengthMenu": [[1,2,3,5,10, -1], [1,2,3,5,10, "All"]],           
    	         	 "pageLength" : 5,
    	         	 "oSearch" : {"sSearch":sCondition}
    	    });
    	});
</script>
</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-background">
	<div class="navbar-wrapper">
	    <div class="container">
	
	        <nav class="navbar navbar-inverse navbar-static-top">
	            <div class="container">
	                <div class="navbar-header">
	                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	                        <span class="sr-only">Toggle navigation</span>
	                        <span class="icon-bar"></span>
	                        <span class="icon-bar"></span>
	                        <span class="icon-bar"></span>
	                    </button>
	                    <a class="navbar-brand" href="#">Girls Dresses Store</a>
	                </div>
	                <div id="navbar" class="navbar-collapse collapse">
	                    <ul class="nav navbar-nav">
	                        <li><a href="<c:url value="/" />">Home</a></li>
	                        <li><a href="<c:url value="/productlist" />">Products</a></li>
	                       
	                        <li>
	                        <sec:authorize access="hasRole('ROLE_ADMIN')">
	                         <a href="<c:url value="/admin/productInventory" />">Product Inventory</a>
	                        </sec:authorize>
	                    <%--     <c:if test="${not empty pageContext.request.userPrincipal}">
                                 <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
								
								       <a>Product Inventory</a>
								
								    </c:if>
								
								<c:if test="${pageContext.request.userPrincipal.name eq 'admin'}">
								
								
								</c:if>
								   
	                       </c:if> --%>
	                        
	                        </li>
	                    </ul>
	                    
<!-- 	                    mahmoud elkhouly:-  here you can add your work and the page you created dont forget to use footer and header  
	                    you will find some data will not show  till user login "you can change the name for properties just let me know" -->
	                    
	                    <ul class="nav navbar-nav pull-right">
	                    
	                    
	                    
	                    
	                    <li><a href="<c:url value="/myProfile/${pageContext.request.userPrincipal.name}" />">${pageContext.request.userPrincipal.name}</a></li>
	                   
	                    <li>
	                   
	                    <c:choose>
							<c:when test="${pageContext.request.userPrincipal.name != null}">
							 <a href="<c:url value="/logout"/>">Logout</a>
                            </c:when>
							<c:otherwise>
							 <a href="<c:url value="/login" />">login</a>
							</c:otherwise>
							</c:choose>
						                       
	                    </li>
	                    </ul>
	                </div>
	            </div>
	        </nav>
	
	    </div>
	</div>
</div>