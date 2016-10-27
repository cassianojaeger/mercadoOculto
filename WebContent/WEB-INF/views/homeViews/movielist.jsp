<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<!-- RETIRAR -->
<%@page session="true"%>
<!-- RETIRAR -->

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/movielist.css"/>"
	rel="stylesheet" type="text/css" />
<title>Mega Filmes IMDb</title>
</head>
<body>

	<br>
	<br>
	<br>
		<c:forEach var="movies" items="${movies}">
			<div class="container">
				<div class="row">
					<div class="well">
						<div class="list-group">
							<a href="<c:url value="/home/info/${movies.id}"/>"
								class="list-group-item active">
								<div class="media col-md-3">
									<figure class="pull-left">
										<img class="media-object img-rounded img-responsive"
											src="http://placehold.it/350x250" alt="placehold.it/350x250">
									</figure>
								</div>
								<div class="col-md-6">
									<h2 class="list-group-item-heading">${movies.title}</h2>
									<br>
									<div class="stars" style="font-size: 40px;">
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star-empty"></span>
									</div>
									<p>
										Average ${movies.rating} <small> / </small> 5
									</p>
								</div>
								<div class="col-md-3 text-center">
									<br> <br> <br> <br>
									<button type="button" class="btn btn-default btn-lg btn-block">
										See more!</button>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

		<br>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>