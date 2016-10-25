<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../header.jsp"></jsp:include>
	<title>IMDB</title>
</head>
<body>
	<label><h1>${success}</h1></label>
	<a href="<c:url value="/admin/userlist"/>"/>List all existing users</a>
</body>
</html>