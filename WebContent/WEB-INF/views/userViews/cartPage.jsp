<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<jsp:include page="../header.jsp" />
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/js/tablelink.js"/>"></script>
<script src="https://code.jquery.com/jquery-3.1.1.js"
	integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
	crossorigin="anonymous"></script>
</head>
<body>
<div  style="height: 70%">
	<table class="table table-hover" style="width: 60%; margin: auto;">
		<thead>
			<tr>
				<th></th>
				<th>Product ID</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Preço</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${cart}" var="cart">
			<tr class='clickable-row' data-href='<c:url value="/home/info/${cart.id}"/>' >
				<th>
					<div class="post-img-content"
					style="float: left; padding-right: 10px; padding-bottom: 10px">
					<a href="<c:url value="/home/info/${cart.id}"/>"><img
						src="<c:url value="${cart.thumbnail}"/>" class="img-responsive"
						style="width: 100px; height: 100px" /></a>
					</div>
				</th>
				<div class="padding-top: 100px">
				<th>${cart.id}</th>
				<td>${cart.name}</td>								
				<td>${cart.description}</td>
				<td>${cart.price}</td>
				
			</tr>		
		</c:forEach>
		</tbody>
	</table>
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>