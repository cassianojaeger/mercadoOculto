<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../header.jsp"></jsp:include>
<html>
<head>
<link href="<c:url value="/resources/css/star.css"/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value="/resources/js/star.js"/>"></script>
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
					style="float: left; height: 268; width: 168px">
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
							<div class="alert alert-info"
								style="display: inline; padding: 5px">${message}</div>
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
			<li class="list-group-item">Rating: <div id="hearts-existing" class="starrr" data-rating='${movie.rating}'>${movie.rating}/5</div></li>
		</ul>
	</div>
	<div id="commentDiv" style="width: 90%; margin: 50px auto;">
		<sec:authorize access="isAuthenticated()">			
			<form:form servletRelativeAction="/user/comment/${movie.id}"
				method="POST">
				<h2>Comment session</h2>
				<input name="comment" id="comment"
					class="form-control"  />
					<br>
				<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> Share</button>
			</form:form>
		</sec:authorize>
		<!-- 		COMMENT HTML -->
		
		<c:forEach items="${movie.comments}" var="comment">
			<div class="row">
				<div class="col-sm-1">
					<div class="thumbnail">
						<img class="img-responsive user-photo"
							src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
					</div>
					<!-- /thumbnail -->
				</div>
				<!-- /col-sm-1 -->

				<div class="col-sm-5">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong>${comment.user}</strong>
						</div>
						<div class="panel-body">${comment.comment}</div>
						<!-- /panel-body -->
					</div>
					<!-- /panel panel-default -->
				</div>
				<!-- /col-sm-5 -->
			</div>
		</c:forEach>
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>