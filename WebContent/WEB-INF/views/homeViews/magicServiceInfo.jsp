<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="<c:url value="/resources/css/movielist.css"/>" rel="stylesheet"
	type="text/css" />
	
<jsp:include page="../header.jsp"></jsp:include>
<html>
<head>
</head>
<body>

	<div class="panel panel-default" style="width: 80%; margin: 0 auto">
		<!-- Default panel contents -->
		<div class="panel-heading">
			<h2>${magicService.name}</h2>
		</div>
		<div class="panel-body" style="position: relative">
			<p>
				<img class="media-object img-rounded img-responsive"
					src="<c:url value="${magicService.thumbnail}"/>"
					style="float: left; height: 268; width: 168px">
			</p>
			<div style="margin-left: 17%; max-width: 80%;">
				<h3>Descrição do item mágico</h3>
				<p>${magicService.description}</p>
			</div>
			
		</div>

		<!-- List group -->
		<ul class="list-group">
			<li class="list-group-item">Nome: ${magicService.name}</li>
			<li class="list-group-item">Tempo de espera do feitiço: ${magicService.waitingTime}</li>
			<li class="list-group-item">Vendedor: <a href="<c:url value="/user/profile/${magicService.owner.id}"/>" >${magicService.owner.name}</a></li>
			<li class="list-group-item">Preço: R$ ${magicService.price}</li>
			<li class="list-group-item">Lista de requisitos:${magicService.requirementsList}</li>
		</ul>
	</div>
	<div style="bottom: 10px; float: right; margin-right: 10%; padding-top: 25px">
				<sec:authorize access="isAuthenticated()">
					<form:form class="form-inline"
						servletRelativeAction="/user/addToCart/${magicService.id}"
						method="POST">

						<button type="submit" class="btn btn-default btn-sm btn-primary">
							<h4><i class="glyphicon glyphicon-ok"></i>Adicionar ao carrinho</h4>
						</button>
						<c:if test="${not empty message}">
							<div class="alert alert-info"
								style="display: inline; padding: 5px">${message}</div>
						</c:if>
					</form:form>
				</sec:authorize>
	</div>
	
	<div id="commentDiv" style="width: 90%; margin: 50px auto;">
		<sec:authorize access="isAuthenticated()">			
			<form:form servletRelativeAction="/user/comment/${magicService.id}"
				method="POST">
				<h2>Comment session</h2>
				<input name="comment" id="comment"
					class="form-control"  />
					<br>
				<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i>Comente</button>
			</form:form>
		</sec:authorize>
		<!-- 		COMMENT HTML -->
		
		<c:forEach items="${magicService.comments}" var="comment">
			<div class="row">
				<div class="col-sm-1">
					<div class="thumbnail">
						<img class="img-responsive user-photo"
							src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
					</div>
					<!-- /thumbnail -->
				</div>
				<div class="col-sm-5">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong>${comment.user}</strong>
						</div>
						<div class="panel-body">${comment.comment}</div>
					</div>
				</div> 
				<!-- /col-sm-5 -->
			</div>
		</c:forEach>
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>