<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>BBQ Grill Reservation</title>
</head>
<body>
	<h1>Register Account</h1>
	<form:form modelAttribute="signup" servletRelativeAction="/signup/create" method="POST">
		Your name: 
		<form:input path="name"/>
		<form:errors path="name"/><br>
		
		: 
		<form:input path="reservationDate" type="datetime-local"/>
		<form:errors path="reservationDate"/><br>
		<form:button>Save</form:button>
	</form:form>

${oi}
		
</body>
</html>