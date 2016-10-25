<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp"></jsp:include>
<title>Users List</title>
</head>
<body>
	<div style="width: 13%; margin: 0 auto">
		<h1>Mega Filmes IMDb</h1>
		<br> <br>
		<table>
			<tr>
				<th>Id</th>
				<th>Title</th>
			</tr>
			<c:forEach var="movie" items="${movies}">
				<tr>
					<td>${movie.id}  </td>
					<td>${movie.title}  </td>

					<td><a
						href="<c:url value="/admconsole/editMovie/${movie.id}"/>" /> Change </a></td>
					<td><a
						href="<c:url value="/admconsole/deleteMovie/${movie.id}"/>" /> Delete </a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>