<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h3>My customer Login page</h3>
	<form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
	<!--  czesc for loging error -->
	<c:if test="${param.error != null}">
		<i>Sorry! wrong user & password</i>
	</c:if>
	<p>User name: <input type="text" name="username"/></p>
	<p>pasword: <input type="password" name="password"/></p>
	<input type="submit" value="login"/>
	</form:form>
</body>
</html>