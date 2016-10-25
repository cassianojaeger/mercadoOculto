<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../header.jsp"></jsp:include>
	<title>Registering new Movie</title>
</head>
<body>
	<h1>Movie attributes</h1>
	<form:form modelAttribute="movie" servletRelativeAction="/admin/registermovie" method="POST">
		Title:
		<form:input path="title"/>
		<form:errors path="title"/><br>
		
		ReleaseDate 
		<form:input path="releaseDate" type="datetime-local"/>
		<form:errors path="releaseDate"/><br>
		
		Synopsis: <br>
		<form:textarea path="synopsis" rows="10" cols="20"/>
		<form:errors path="synopsis"/><br>
		
		Lenght: 
		<form:input path="lenght"/>
		<form:errors path="lenght"/><br>
		
		Genre: <br> 
		<form:textarea path="genre" rows="10" cols="20"/>
		<form:errors path="genre"/><br>
		
<!-- 		FAZER A THUMBNAIL AMANHA -->
		
		<form:button>Save</form:button>
	</form:form>

		
</body>
</html>