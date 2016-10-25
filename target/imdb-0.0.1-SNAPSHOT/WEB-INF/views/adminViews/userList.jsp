<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>Users List</title>
</head>
<body>
	<h1>List of users</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>User name</th>
			<th>User email</th>
			<th>User last login</th>
		</tr>
		<c:forEach var="users" items="${users}">
			<tr>
				<td>${users.id}</td>
				<td>${users.name}</td>
				<td>${users.email}</td>
				<td>${users.lastLoginDate}</td>
				<td><a href="<c:url value="/admconsole/editUser/${users.id}"/>"/>Change</a></td>
				<td><a href="<c:url value="/admconsole/deleteUser/${users.id}"/>"/>Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>