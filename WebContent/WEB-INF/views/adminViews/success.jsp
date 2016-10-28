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
	<div style="text-align: center; width: 100%"><label><h1>${success}</h1></label></br>
	<a href="<c:url value="/home"/>"/>List all existing movies</a></div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>