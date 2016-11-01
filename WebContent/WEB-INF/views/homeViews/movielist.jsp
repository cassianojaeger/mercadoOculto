<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<jsp:include page="../header.jsp" />
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/toggle.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/movielist.css"/>"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/search.css"/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js"/>"></script>
<script
  src="https://code.jquery.com/jquery-3.1.1.js"
  integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
  crossorigin="anonymous"></script>
<title>Mega Filmes IMDb</title>
</head>
<body>
	
	
	<br>
	
	<div style="width: 70%; margin: 0 auto 25px auto">
		<div class="row">
			<h2>Search movie by name Bem vindo, ${username}! </h2>
			<div id="custom-search-input">
				<div class="input-group col-md-12">
					<input type="text" class="  search-query form-control"
						placeholder="Search" id="search" /> <span class="input-group-btn">
						<button class="btn btn-danger" type="button">
							<span class=" glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
		</div>
	</div>
	<div class="container" id="movies-display">		
			<jsp:include page="movie-template.jsp"></jsp:include>					
	</div>
	<br>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>