<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<title>Mercado Oculto</title>
<html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.1.1.js"/>"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/home/"/>"> Mercado
					Oculto <img
							src="<c:url value="/resources/uploaded-thumbnails/hat.png"/>" class="img-responsive"
							style="width: 40px; height: 40px; display: inline; margin-top: -10px"/></a>
				
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<sec:authorize access="isAuthenticated()">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">
								Olá, <sec:authentication property="principal.username" /> <i
								class="caret"></i>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><c:url var="logoutUrl" value="/logout" />
									<form class="form-inline" action="${logoutUrl}" method="post">
										<input type="submit" value="Deslogar" class="btn btn-link" />
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</form></li>
								<li><sec:authorize access="isAuthenticated()">
										<form class="form-inline" action="/user/profile" method="GET">
											<a class="btn btn-link" type="submit"
												href="<c:url value="/user/profile"/>" />Perfil de Usuário</a>
										</form>
									</sec:authorize></li>
								<li><sec:authorize access="isAuthenticated()">
										<form class="form-inline" action="/user/orderHistory" method="GET">
											<a class="btn btn-link" type="submit"
												href="<c:url value="/user/orderHistory"/>" />Histórico de compra</a>
										</form>
									</sec:authorize></li>
								<li><sec:authorize access="hasRole('ROLE_BRUXO')">
										<form class="form-inline" action="/create-products/magicItem"
											method="GET">
											<a class="btn btn-link" type="submit"
												href="<c:url value="/create-products/magicItem"/>" />Vender novo item mágico</a>
										</form>
									</sec:authorize></li>
								<li><sec:authorize access="hasRole('ROLE_BRUXO')">
										<form class="form-inline"
											action="/create-products/magicService" method="GET">
											<a class="btn btn-link" type="submit"
												href="<c:url value="/create-products/magicService"/>" />Vender novo feitiço mágico</a>
										</form>
									</sec:authorize></li>
							</ul></li>
						<sec:authorize access="hasRole('ROLE_MODERADOR')">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false">
									Painel de gerenciamento <i class="caret"></i>
							</a>
							<ul class="dropdown-menu" role="menu">
								<li>
										<form class="form-inline"
											action="/moderator-console/view-all-products" method="GET">
											<a class="btn btn-link" type="submit"
												href="<c:url value="/moderator-console/view-all-products"/>" />Gerenciar Produtos</a>
										</form>

								</li>
								<li>
										<form class="form-inline"
											action="/moderator-console/view-all-products" method="GET">
											<a class="btn btn-link" type="submit"
												href="<c:url value="/moderator-console/view-all-users"/>" />Gerenciar Usuários</a>
										</form>
								
								</li>
							</ul>
						</li>
						</sec:authorize>
					</sec:authorize>
				</ul>
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="<c:url value="/home/view-all-vendors"/>" class="dropdown-toggle"
								">
								Procure por vendedores <i class="glyphicon glyphicon-zoom-in"></i>
							</a>
					</li>
				</ul>
				
				
				
				
				
				<div id="login" class="navbar-form navbar-right">
					<sec:authorize access="isAnonymous()">
						<a class="btn btn-primary" href="<c:url value="/login"/>" />Logar</a>
					</sec:authorize>
					<a class="btn btn-primary" href="<c:url value="/signup/"/>" />Registrar-se</a>
				</div>

			</div>
		</div>
	</nav>
</body>
</html>