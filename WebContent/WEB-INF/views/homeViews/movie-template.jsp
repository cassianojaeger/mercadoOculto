<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- <!-- <script> --> -->
<!-- // $(document).ready(function() { -->
<!-- // 	$("#wishlistButton").click(function(){ -->
<!-- // 		$.ajax({ -->
<!-- // 			url : '/imdb/user/saveRemoveWishlist', -->
<!-- // 			data : { -->
<!-- // 				movie : $("#wishlistButton").attr("data-id"), -->
<!-- // 				user  : $("#wishlistButton").attr("user-username") -->
<!-- // 			} -->
<!-- // 		}) -->
<!-- // 	}); -->
<!-- // }); -->
	
<!-- <!-- </script> --> -->
<div class="row">
	<c:forEach var="movies" items="${movies}">
		<!-- PEGAR DAQUI -->
		<div class="col-sm-8 col-md-6"
			style="background-color: #f6f6f5; border: #fff 1px solid;">
			<div class="post">
				<div class="post-img-content"
					style="float: left; padding-right: 10px; padding-bottom: 10px">
					<a href="<c:url value="/home/info/${movies.id}"/>"><img
						src="<c:url value="${movies.thumbnail}"/>" class="img-responsive"
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
						<small style="color: #666666; text-align: justify"><p>${movies.synopsis}</p></small>
					</div>
				</div>
			</div>
			<div style="position: absolute; bottom: 10px; margin-left: 33%">
				<sec:authorize access="isAuthenticated()">
				<form:form class="form-inline"
					servletRelativeAction="/user/addWishlist/${movies.id}"
					method="POST">
					<div data-toggle="buttons" style="display: inline">
						<button id="wishlistButton" type="submit" class="btn btn-default btn-sm" onclick="wishList()" 
							data-id="${movies.id}" user-username="<sec:authentication property="principal.username" />">
							<i class="glyphicon glyphicon-ok"></i> Wishlist
						</button>
					</div>
				</form:form>
			</sec:authorize>
			</div>
			<div style="position: absolute; bottom: 10px; margin-left: 66%">
				<sec:authorize access="hasAnyRole('ROLE_MOD', 'ROLE_ADMIN')">
					<a href="<c:url value="/admconsole/editMovie/${movies.id}"/>"
						class="btn btn-warning btn-sm"><i
						class="glyphicon glyphicon-pencil"></i> Edit</a>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<form:form class="form-inline"
						servletRelativeAction="/admconsole/deleteMovie/${movies.id}"
						method="POST">
						<button type="submit" class="btn btn-danger btn-sm">
							<i class="glyphicon glyphicon-remove"></i> Delete
						</button>
					</form:form>
				</sec:authorize>
			</div>	
		</div>
	</c:forEach>
</div>
<!-- PEGAR DAQUI -->
