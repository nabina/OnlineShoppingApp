<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<c:url var="loginUrl" value="/login" />

<div class="container-wrapper">
    <div class="container">
        <div id="login-box" class="loginBox">
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                Invalid username and password.
            </div>
        </c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if> 
            <h2>Sign in</h2>
            <form name='loginForm' action="${loginUrl}" method='POST'>
            
                <div class="form-group">
                    <label for="username">User:</label>
                    <input type="text" id="username" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" />
                </div>
                <input type="submit" value="Submit" class="btn btn-success btnWidth120">
            </form>
            
            <br/>
            <span><a href="registration">Registration</a></span>
        </div>
        <%@ include file="/WEB-INF/views/template/footer.jsp" %>
        </div>
        
        </div>



