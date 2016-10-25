<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<title>IMDB Movies</title>
</head>
<body>
	<h1 style=" margin-left:7%">IMDB Movies</h1>

	<c:forEach var="movies" items="${movies}">
		<hr style="margin: 3% 10% 2% 10%">
		<div id="one" style="float: left; margin-left:10%"><img alt="NAO TEM IMAGEM" itemprop="image" 
			width="140px" height="200px" />
			
		</div>
		
		<div id="two" style="margin-left:15%; margin-right: 10%">
			<h2>${movies.title} (${movies.releaseDate.year})</h2> 
			<h5 style="margin-top:-10px">${movies.lenght} mins - ${movies.genre} </h5>
			${movies.synopsis}<br> 
			
			<br>
			
		</div>
		
		<br><br><br><br><br><br>
	</c:forEach>

	<br>
</body>