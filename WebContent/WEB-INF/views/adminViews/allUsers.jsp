<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="<c:url value="/resources/css/movielist.css"/>" rel="stylesheet"
	type="text/css" />
	
<jsp:include page="../header.jsp" />
<html>

<div class="container">
	<h2>Users list</h2>
	<p>See all users registered in our system</p>
	<c:if test="${not empty deleteError}">
				<div class="alert alert-danger"
					style="text-align: center; padding: 5px; width: 40%; margin: 0 auto 10px auto">
					${deleteError}</div>
	</c:if>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>User Name</th>
				<th>User System Name</th>
				<th>User Role</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.name}</td>
					<td>${user.username}</td>
					<td>${user.userTypes}</td>
					<td>
						<form:form class="form-inline"
							servletRelativeAction="/moderator-console/delete-user/${user.id}"
							method="POST">
							<button type="submit" class="btn btn-danger btn-sm">
								<i class="glyphicon glyphicon-remove"></i> Delete
							</button>
						</form:form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>





<jsp:include page="../footer.jsp"></jsp:include>
</html>
