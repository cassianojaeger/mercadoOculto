<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp"></jsp:include>
<html>
<head>
<title>Mega Filmes IMDb</title>
</head>
<body>
	<div class="panel panel-default" style="width: 80%; margin: 0 auto">
		<!-- Default panel contents -->
		<div class="panel-heading">
			<h2>${movie.title}-(${movie.releaseDate.year})</h2>
		</div>
		<div class="panel-body" style="position: relative">
			<p>
				<img class="media-object img-rounded img-responsive"
					src="<c:url value="${movie.thumbnail}"/>"
					alt="placehold.it/350x250" style="float: left; height: 250px">
			</p>
			<div style="margin-left: 17%; max-width: 80%;">
				<h3>Synopsis</h3>
				<p>${movie.synopsis}</p>
			</div>
			<div style="position: absolute; bottom: 10px; margin-left: 16.8%">
				<sec:authorize access="isAuthenticated()">
					<form:form class="form-inline"
						servletRelativeAction="/user/saveRemoveWishlist/${movie.id}"
						method="POST">

						<button type="submit" class="btn btn-default btn-sm">
							<i class="glyphicon glyphicon-ok"></i> Wishlist
						</button>
						<c:if test="${not empty message}">
							<div class="alert alert-info" style="display: inline; padding: 5px">
								${message}								
							</div>
						</c:if>

					</form:form>
				</sec:authorize>
			</div>
		</div>

		<!-- List group -->
		<ul class="list-group">
			<li class="list-group-item">Title: ${movie.title}</li>
			<li class="list-group-item">Release Date:
				${movie.releaseDate.dayOfMonth}/${movie.releaseDate.monthValue}/${movie.releaseDate.year}</li>
			<li class="list-group-item">Lenght: ${movie.length} minutes</li>
			<li class="list-group-item">Genres: | <small
				style="color: #666666"> <c:forEach items="${movie.genre}"
						var="genre">
				${genre} |			
			</c:forEach></small>
			</li>
			<li class="list-group-item">Rating: ${movie.rating}</li>
		</ul>
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>