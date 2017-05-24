<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link href="<c:url value="/resources/css/signup.css"/>" rel="stylesheet"
	type="text/css" />
<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<!-- CSS -->

<!-- 	SCRIPTS -->

<script type="text/javascript"
	src="<c:url value="/resources/js/signup.js"/>"></script>
<!-- 	SCRIPTS -->

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mercado Oculto</title>
</head>
<body>
	<div class="container"
		style="width: 20%; margin: 0 auto; margin-top: -5%">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">Registre-se</h1>
					<hr />
				</div>
			</div>
			<div class="main-login main-center">
				<form:form class="form-horizontal" modelAttribute="user"
					servletRelativeAction="/signup" method="POST">
					<c:if test="${not empty error}">
						<div class="error" style="text-align: center">${error}</div>
					</c:if>
					
					<div class="jsError" style="text-align: center"></div>
					
					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Nome</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span>
								<form:input type="text" class="form-control" path="name"
									id="name" placeholder="Digite seu nome" />
								<form:errors path="name" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">E-mail</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-envelope fa" aria-hidden="true"></i></span>
								<form:input type="text" class="form-control" path="email"
									id="email" placeholder="Digite seu e-mail" />
								<form:errors path="name" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Username</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa"
									aria-hidden="true"></i></span>
								<form:input type="text" class="form-control" path="username"
									id="username" placeholder="Digite seu username" />
								<form:errors path="username" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="userTypes" class="cols-sm-2 control-label">Tipo de usuário</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa"
									aria-hidden="true"></i></span>
								<form:select path="userTypes" placeholder="" class="form-control"
									items="${userTypeList}" multiple="false" size="3" />
								<form:errors class="error" path="userTypes" /> 
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Senha</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
								<form:input type="password" class="form-control" path="password"
									id="password" placeholder="Digite sua senha" />
								<form:errors path="password" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="confirmMessage" class="cols-sm-2 control-label">Confirme a senha
							</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
									type="password" class="form-control" name="pass2" id="pass2"
									placeholder="Confirme sua senha"
									onkeyup="checkPass(); return false; " />
							</div>
							<span id="confirmMessage" class="confirmMessage"></span>
						</div>
					</div>

					<div class="form-group">
						<form:button type="button" id="submitButton"
							class="btn btn-primary btn-lg btn-block login-button">Registrar</form:button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>