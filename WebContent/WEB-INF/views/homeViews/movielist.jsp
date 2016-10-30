<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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

	<div class="container">
		<div class="row">
			<c:forEach var="movies" items="${movies}">
				<!-- PEGAR DAQUI -->
				<div class="col-sm-8 col-md-6"
					style="background-color: #f6f6f5; border: #fff 1px solid;">
					<div class="post">
						<div class="post-img-content"
							style="float: left; padding-right: 10px; padding-bottom: 10px">
							<img src="${movies.thumbnail}" class="img-responsive" />
						</div>
						<div class="content" style="">
							<span class="post-title"><b><h4>${movies.title}
										(${movies.releaseDate.year})</h4></b></span>
							<div class="author">
								<small style="color: #666666"><b>${movies.genre}</b> | <time
										datetime=${movies.releaseDate}>${movies.length} mins</time></small> </br>
							</div>
							<div>
								<p>${movies.synopsis}</p>
							</div>
						</div>
					</div>
					<div style="position: absolute; bottom: 10px; margin-left:40%">
						<a href="<c:url value="/home/info/${movies.id}"/>"
							class="btn btn-primary btn-sm">More info</a>
						<sec:authorize access="hasAnyRole('ROLE_MOD', 'ROLE_ADMIN')">
							<a href="<c:url value="/admconsole/editMovie/${movies.id}"/>"
								class="btn btn-warning btn-sm">&nbsp;&nbsp;&nbsp;Edit&nbsp;&nbsp;&nbsp;</a>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<a href="<c:url value="/admconsole/deleteMovie/${movies.id}"/>"
									class="btn btn-danger btn-sm">Delete</a>
							</sec:authorize>
						</sec:authorize>
					</div>
				</div>
			</c:forEach>
			<!-- PEGAR DAQUI -->
		</div>
	</div>



	<br>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>