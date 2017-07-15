
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="<c:url value="/resources/css/movielist.css"/>" rel="stylesheet"
	type="text/css" />
	
<jsp:include page="../header.jsp" />
<html>
<div class="panel panel-default" style="width: 80%; margin: 0 auto">
	<!-- Default panel contents -->
	<div class="panel-heading">
		<h2>${user.username}</h2>
	</div>
	<div class="panel-body" style="position: relative">
		<p>
		<c:choose>
			<c:when test="${user.userTypes == 'BRUXO'}">
				<img class="media-object img-rounded img-responsive"
				src="<c:url value="/resources/uploaded-thumbnails/bruxo.png"/>"
				style="float: left; height: 168px; width: 168px">
			</c:when>
			<c:when test="${user.userTypes == 'NORMAL'}">
				<img class="media-object img-rounded img-responsive"
				src="<c:url value="/resources/uploaded-thumbnails/normal.png"/>"
				style="float: left; height: 168px; width: 168px">
			</c:when>
			<c:when test="${user.userTypes == 'MODERADOR'}">
				<img class="media-object img-rounded img-responsive"
				src="<c:url value="/resources/uploaded-thumbnails/moderador.png"/>"
				style="float: left; height: 168px; width: 168px">
			</c:when>
		</c:choose>
			
		</p>
		<div style="margin-left: 17%; max-width: 80%;">
			<c:if test="${user.userTypes == 'BRUXO'}">
				<h3>Nível de Vendedor</h3>
				<p>${user.vendorGrade}</p>
			</c:if>
		</div>
		
	</div>

	<!-- List group -->
	<ul class="list-group">
		<li class="list-group-item">Nome: ${user.name}</li>
		<li class="list-group-item">E-mail: ${user.email}</li>
		<li class="list-group-item">Tipo de usuário: ${user.userTypes}</li>
		<li class="list-group-item">Último Login: ${user.lastLogin}</li>
	</ul>
</div>

<!-- PRODUTOS DO USUARIO -->
<c:choose>
	<c:when test="${user.userTypes == 'BRUXO'}" >
	<div class="container" style="margin-top: 50px; width: 82%">
		<h2>Produtos à venda</h2>
		<p>Veja todos os produtos e serviços ofertados por esse Vendedor</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Imagem do produto</th>
					<th>Nome do produto</th>
					<th>Descrição do produto</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<c:if test="${product.id != null}" >
					<tr>
						<td>
							<div class="post-img-content"
								style="float: left; padding-right: 10px; padding-bottom: 10px">
								<a href="<c:url value="/home/info/${product.id}"/>"><img
								src="<c:url value="${product.thumbnail}"/>" class="img-responsive"
								style="width: 100px; height: 100px" /></a>
							</div>
						</td>
						<td>${product.name}</td>
						<td>${product.description}</td>
					</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</c:when>
	<c:otherwise>

	</c:otherwise>
</c:choose>
<div id="commentDiv" style="width: 90%; margin: 50px auto;">
	<sec:authorize access="isAuthenticated()">			
		<form:form servletRelativeAction="/user/comment/${user.id}"
			method="POST">
			<h2>O que você acha desse usuário?</h2>
			<input name="comment" id="comment"
				class="form-control"  />
				<br>
			<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i>Comente</button>
		</form:form>
	</sec:authorize>
		
	<c:forEach items="${user.comments}" var="comment"> 
		<div class="row">
			<div class="col-sm-1">
				<div class="thumbnail">
					<img class="img-responsive user-photo"
						src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
				</div>
				
			</div>
			<div class="col-sm-5">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong>${comment.user}</strong>
					</div>
					<div class="panel-body">${comment.comment}</div>
				</div>
			</div> 
		</div>
	</c:forEach>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</html>

