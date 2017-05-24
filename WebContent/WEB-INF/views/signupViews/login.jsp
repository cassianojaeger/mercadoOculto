<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div><jsp:include page="../header.jsp"></jsp:include></div>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:tiles="http://www.thymeleaf.org">
<head>
<title>Login Page</title>
<!-- CSS --><!-- CSS --><!-- CSS --><!-- CSS --><!-- CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- CSS --><!-- CSS --><!-- CSS --><!-- CSS --><!-- CSS -->

<!-- 	SCRIPTS --><!-- 	SCRIPTS --><!-- 	SCRIPTS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value="/resources/js/signin.js"/>"></script>
<!-- 	SCRIPTS --><!-- 	SCRIPTS --><!-- 	SCRIPTS -->


</head>
<body>
	<div class="container" style="margin-top: 10%">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<a href="#" class="active" id="login-form-link">Entre na sua conta</a>
						</div>
						<hr>
					</div>
					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>
					</c:if>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" th:action="/login" method="post"
									role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="username" id="username" tabindex="1"
											class="form-control" placeholder="Username" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password1"
											tabindex="2" class="form-control" placeholder="Senha">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit"
													tabindex="4" class="form-control btn btn-login"
													value="Logar">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>