<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>IMDB Movies</title>
</head>
<body>
	<h1>IMDB Movies</h1>
	
	<table>
		<tr>
			<th>Title</th>
			<th>Release Date</th>
			<th>Synopsis</th>
			<th>Lenght</th>
			<th>Genre</th>
		</tr>
		<c:forEach var="movies" items="${movie}">
			<tr>
				<img alt="NAO TEM IMAGEM" itemprop="image" width="280px" height="395px"/>
				<td>${movie.title}</td>
				<td>${movie.releaseDate}</td>
				<td>${movie.synopsis}</td>
				<td>${movie.lenght}</td>
				<td>${movie.genre}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
