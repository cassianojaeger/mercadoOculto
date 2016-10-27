<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
				<a class="navbar-brand" href="<c:url value="/home/"/>">Mega
					Filmes IMDb</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">


					<sec:authorize access="isAuthenticated()">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">
								<p>
									Hello
									<sec:authentication property="principal.username" />
								</p> <span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><c:url var="logoutUrl" value="/logout" />
									<form class="form-inline" action="${logoutUrl}" method="post">
										<input type="submit" value="Log out" class="btn btn-link" />
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</form></li>
								<li>
									<form class="form-inline" action="/admconsole/registermovie"
										method="GET">
										<a class="btn btn-link" type="submit"
											href="<c:url value="/admconsole/registermovie"/>" />Add
										Movie</a>
									</form>

								</li>
								<li>
									<form class="form-inline" action="/admconsole/movielist"
										method="GET">
										<a class="btn btn-link" type="submit"
											href="<c:url value="/admconsole/movielist"/>" />Movie Console</a>
									</form>
								</li>
							</ul></li>
					</sec:authorize>
				</ul>
				<div id="login" class="navbar-form navbar-right">
					<sec:authorize access="isAnonymous()">
						<a class="btn btn-primary" href="<c:url value="/login"/>" />Sign in</a>
					</sec:authorize>
					<a class="btn btn-primary" href="<c:url value="/signup/"/>" />Sign
					up</a>
				</div>

			</div>
		</div>
	</nav>

	<script>
		$(document).ready(function() {
			$(".dropdown-toggle").dropdown();
		});
	</script>
</body>
</html>