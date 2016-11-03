<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<jsp:include page="../header.jsp" />
<!DOCTYPE html>
<html>
<head>
<script>
jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.document.location = $(this).data("href");
    });
});
</script>
<title>Mega Filmes IMDb</title>
</head>
<body>
<div  style="height: 70%">
	<table class="table table-hover" style="width: 60%; margin: auto;">
		<thead>
			<tr>
				<th>MovieID</th>
				<th>Title</th>
				<th>Genre</th>
				<th>Length</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${userMovies}" var="movie">
			<tr class='clickable-row' data-href='<c:url value="/home/info/${movie.id}"/>' >
				
				<th>${movie.id}</th>
				<td>${movie.title}</td>				
				<td>
					 <small style="color: #666666"> |
						<c:forEach
							items="${movie.genre}" var="genre">
							${genre} |			
						</c:forEach>
					</small>
				</td>
				<td>${movie.length}</td>
			
			</tr>		
		</c:forEach>
		</tbody>
	</table>
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>