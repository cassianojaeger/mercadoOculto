<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<title>Mega Filmes IMDb</title>
</head>
<body>
	<form:form class="form-horizontal" modelAttribute="user"
		servletRelativeAction="/signup" method="POST">
		<fieldset style="margin-left: 40%; margin-top: 5%;">
			<label><h1>Register</h1></label>
			<div class="control-group">
				<!-- Username -->
				<label class="control-label" for="username">Username</label>
				<div class="controls">
					<form:input path="username" placeholder="" class="input-xlarge" />
					<form:errors path="username" />
					<p class="help-block">Username can contain any letters or
						numbers</p>
				</div>
			</div>
			<div class="control-group">
				<!-- name -->
				<label class="control-label" for="name">Name</label>
				<div class="controls">
					<form:input path="name" placeholder="" class="input-xlarge" />
					<form:errors path="name" />
					<p class="help-block">Name can contain only letters</p>
				</div>
			</div>

			<div class="control-group">
				<!-- E-mail -->
				<label class="control-label" for="email">E-mail</label>
				<div class="controls">
					<form:input path="email" placeholder="" class="input-xlarge" />
					<form:errors path="email" />
					<br>
					<p class="help-block">Please provide your E-mail</p>
				</div>
			</div>

			<div class="control-group">
				<!-- Password-->
				<label class="control-label" for="password">Password</label>
				<div class="controls">
					<form:input path="password" placeholder="" class="input-xlarge"
						type="password" />
					<form:errors path="password" />
					<p class="help-block">Password should be at least 4 characters</p>
				</div>
			</div>

			<div class="control-group">
				<!-- Button -->
				<div class="controls">
					<form:button class="btn btn-success">Register</form:button>
				</div>
			</div>
		</fieldset>
	</form:form>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>