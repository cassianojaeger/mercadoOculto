<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp"></jsp:include>
	<title>Mega Filmes IMDb</title>
</head>
<body>
	<label><h1>${success}</h1></label>
	<a href="<c:url value="/home"/>"/>List all existing movies</a>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>