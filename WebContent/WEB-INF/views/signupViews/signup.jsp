<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<!-- CSS --><!-- CSS --><!-- CSS --><!-- CSS --><!-- CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link href="<c:url value="/resources/css/signup.css"/>" rel="stylesheet"
	type="text/css" />
<!-- CSS --><!-- CSS --><!-- CSS --><!-- CSS --><!-- CSS -->
<!-- 	SCRIPTS --><!-- 	SCRIPTS --><!-- 	SCRIPTS -->		
<script type="text/javascript"
	src="<c:url value="/resources/js/signup.js"/>"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Mega Filmes IMDb</title>

<script type="text/javascript" src="assets/js/bootstrap.js"></script>
<!-- 	SCRIPTS --><!-- 	SCRIPTS --><!-- 	SCRIPTS -->

</head>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

<!-- Website CSS style -->
<link rel="stylesheet" type="text/css" href="assets/css/main.css">

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

<title>Admin</title>
</head>
<body>
	<div class="container" style="width: 20%; margin: 0 auto; margin-top: -5%">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">Sign Up</h1>
					<hr />
				</div>
			</div>
			<div class="main-login main-center">
				<form:form class="form-horizontal" modelAttribute="user"
					servletRelativeAction="/signup" method="POST">
					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Your
							Name</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span>
								<form:input type="text" class="form-control" path="name"
									id="name" placeholder="Enter your Name" />
								<form:errors path="name" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">Your
							Email</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-envelope fa" aria-hidden="true"></i></span>
								<form:input type="text" class="form-control" path="email"
									id="email" placeholder="Enter your Email" />
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
									id="username" placeholder="Enter your Username" />
								<form:errors path="username" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
								<form:input type="password" class="form-control" path="password"
									id="password" placeholder="Enter your Password" />
								<form:errors path="password" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="confirm" class="cols-sm-2 control-label">Confirm
							Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
									type="password" class="form-control" name="pass2" id="pass2"
									placeholder="Confirm your Password"
									onkeyup="checkPass(); return false;" /> <span
									id="confirmMessage" class="confirmMessage"></span>
							</div>
						</div>
					</div>

					<div class="form-group ">
						<form:button type="submit"
							class="btn btn-primary btn-lg btn-block login-button">Register</form:button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>