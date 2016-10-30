<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
							<a href="<c:url value="/home/info/${movies.id}"/>"><img
								src="${movies.thumbnail}" class="img-responsive"
								style="width: 182px; height: 268px" /></a>
						</div>
						<div class="content" style="">
							<a href="<c:url value="/home/info/${movies.id}"/>"><span
								class="post-title"><b><h4>${movies.title}
											(${movies.releaseDate.year})</h4></b></span></a>
							<div class="author" style="margin-bottom: 5px">
								<small style="color: #666666"><b>${movies.genre}</b> | <time
										datetime=${movies.releaseDate}>${movies.length} mins</time></small> </br>
							</div>
							<div>
								<small style="color: #666666"><p>${movies.synopsis}</p></small>
							</div>
						</div>
					</div>
					<div style="position: absolute; bottom: 10px; margin-left: 40%">						
						<a href="<c:url value="#"/>" class="btn btn-success btn-sm"><i
							class="glyphicon glyphicon-plus"></i> Add to wishlist</a>
						<sec:authorize access="hasAnyRole('ROLE_MOD', 'ROLE_ADMIN')">
							<a href="<c:url value="/admconsole/editMovie/${movies.id}"/>"
								class="btn btn-warning btn-sm"><i
								class="glyphicon glyphicon-pencil"></i> Edit</a>							
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
								<form:form class="form-inline" 
 									servletRelativeAction="/admconsole/deleteMovie/${movies.id}" method="POST"> 
									<button type="submit" class="btn btn-danger btn-sm">
										<i class="glyphicon glyphicon-remove"></i> Delete
									</button>
 								</form:form> 
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