<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  display user name and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	<security:authorize access="hasRole('MANAGER')">
	<!--  add link to point to leaders -->
	<p><a href="${pageContext.request.contextPath}/managers">Managers stuff</a></p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<!--  admins stuff -->
	<p><a href="${pageContext.request.contextPath}/admins">Admins stuff</a></p>
	</security:authorize>
	
	<h3>welcome</h3>
	<!--  add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="logout"/>
	</form:form>
</body>
</html>