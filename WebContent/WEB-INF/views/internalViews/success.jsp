<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../header.jsp"></jsp:include>
	<title>Mega Filmes IMDb</title>
</head>
<body>
	<div style="text-align: center; width: 100%">
	<h1>${success}</h1>
	<a href="<c:url value="/home"/>">Home page</a>
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>