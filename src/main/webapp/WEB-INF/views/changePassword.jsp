<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div id="login-box" class="loginBox">
        
            <h2>Change password</h2>
            <form:form action="" method="post" commandName="password">
            
                <!-- <div class="form-group">
                    <label for="username">User:</label>
                    <input type="text" id="username" name="username" class="form-control" />
                </div> -->
                <table>
	<tr>
			<td>Old password:</td>
			 <td><form:input path="oldPassword"/><font color="red"><form:errors path="oldPassword" /></font></td>
		</tr>
		<tr>
			<td>New password:</td>
			 <td><form:input path="newPassword"/><font color="red"><form:errors path="newPassword" /></font></td>
		</tr>
		<tr>
			<td>Confirm password:</td>
			 <td><form:input path="confirmPassword"/><font color="red"><form:errors path="confirmPassword" /></font></td>
		</tr>
		
	</table> 
	 <input type="submit" class="btn btn-primary"/>
            </form:form>
            
           
           
        </div>
        <%@ include file="/WEB-INF/views/template/footer.jsp" %>
        </div>
        
        </div>

