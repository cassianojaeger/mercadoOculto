<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>User sign up</title>
</head>
<body>
	<h1>Register Account</h1>
	<form:form modelAttribute="user" servletRelativeAction="/signup" method="POST">
		Your name: 
		<form:input path="name"/>
		<form:errors path="name"/><br>
		
		Email: 
		<form:input path="email" />
		<form:errors path="email"/><br>
		
		Password: 
		<form:input path="password" />
		<form:errors path="password"/><br>
		
		<form:input type="hidden" path="userType" value="NORMAL" />
		
		<form:button>Save</form:button>
	</form:form>

		
</body>
</html>