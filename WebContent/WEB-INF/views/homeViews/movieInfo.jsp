<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<html>
<head>
<title>Mega Filmes IMDb</title>
</head>
<body>
	<div class="panel panel-default" style="width: 80%; margin: 0 auto">
		<!-- Default panel contents -->
		<div class="panel-heading">
			<h2>${movie.title} - (${movie.releaseDate.year})</h>
		</div>
		<div class="panel-body">
			<p>
				<img class="media-object img-rounded img-responsive"
					src="http://placehold.it/350x250" alt="placehold.it/350x250"
					style="float: left">
			</p>
			<div style="margin-left: 30%; max-width: 80%; ">
				<h3>Synopsis</h3>
				<p >${movie.synopsis}</p>
			</div> 
		</div>

		<!-- List group -->
		<ul class="list-group">
			<li class="list-group-item">Title: ${movie.title}</li>
			<li class="list-group-item">Release Date: ${movie.releaseDate.dayOfMonth}/${movie.releaseDate.monthValue}/${movie.releaseDate.year}</li>
			<li class="list-group-item">Lenght: ${movie.length} minutes</li>
			<li class="list-group-item">Genres: |
			<c:forEach items="${movie.genre}" var="genre">
				${genre} |			
			</c:forEach>
			
			
			</li>
			<li class="list-group-item">Rating: ${movie.rating}</li>
		</ul>
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>