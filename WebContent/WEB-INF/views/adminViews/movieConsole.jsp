<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp"></jsp:include>
<title>Users List</title>
</head>
<body>
	<div style="width: 20%; margin: 0 auto; text-align: center">
		<h1>Mega Filmes IMDb</h1>
		<br> <br>
		<table>
			<tr>
				<th>&nbsp;Id&nbsp;</th>
				<th>&nbsp;Title&nbsp;</th>
			</tr>
			<c:forEach var="movie" items="${movies}">
				<tr>
					<td>${movie.id}  </td>
					<td>${movie.title}  </td>

					<td><a
						href="<c:url value="/admconsole/editMovie/${movie.id}"/>" />&nbsp;&nbsp;[ Change ]</a></td>
					<td><a
						href="<c:url value="/admconsole/deleteMovie/${movie.id}"/>" />&nbsp;&nbsp;[ Delete ] </a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>