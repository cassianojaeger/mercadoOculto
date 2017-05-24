<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp"></jsp:include>
<title>Mercado Oculto</title>
<!-- CSS -->
<!-- CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link href="<c:url value="/resources/css/signup.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/comment.css"/>" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
<!-- CSS -->
<!-- CSS -->


</head>
<body>

	<form:form class="form-horizontal" modelAttribute="magicServices"
		servletRelativeAction="/create-products/magicService?${_csrf.parameterName}=${_csrf.token}" 
		method="POST"
		enctype="multipart/form-data">
		<fieldset style="width: 50%; margin: 0 auto">
			<label><h1>Registro de serviços de magia</h1></label>
			<c:if test="${not empty error}">
						<div class="error" style="text-align: center">${error}</div>
			</c:if>
			<div class="control-group">
				<!-- title -->
				<label class="control-label" for="name">Nome</label>
				<div class="controls">
					<form:input path="name" placeholder="" class="form-control" />
					<form:errors class="error" path="name" />
				</div>
			</div>

			<div class="control-group">
				<!-- description -->
				<label class="control-label" for="description">Descrição</label>
				<div class="controls">
					<form:textarea path="description" placeholder="Description..."
						class="form-control" rows="5" cols="30" />
					<form:errors class="error" path="description" />
					<br>
				</div>
			</div>
			
			<div class="control-group">
				<!-- price -->
				<label class="control-label" for="price">Preço</label>
				<div class="controls">
					<form:input path="price" placeholder="price..." class="form-control" type="number" step="any" />
					<form:errors class="error" path="price" />
					<br>
				</div>
			</div>

			<div class="control-group">
				<!-- thumbnail -->
				<label class="control-label" for="thumbnail">URL da Thumbnail 
					path</label>
				<div class="controls">
					<input	name="file" class="form-control" type="file" />
					<form:errors class="error" path="thumbnail" />
				</div>
			</div>
			
				<div class="control-group">
				<!-- waitingTime -->
				<label class="control-label" for="waitingTime">Tempo de espera</label>
				<div class="controls">
					<form:input path="waitingTime" placeholder="Tempo de espera..." class="form-control" type="number" />
					<form:errors class="error" path="waitingTime" />
					<br>
				</div>
			</div>
			
				<div class="control-group">
				<!-- requirementsList -->
				<label class="control-label" for="requirementsList">Lista de requisitos para o feitiço</label>
				<div class="controls">
					<form:textarea path="requirementsList" placeholder="Separe os elementos por algum limitador para facilitar a visualização" class="form-control" type="text" rows="5" cols="30" />
					<form:errors class="error" path="requirementsList" />
					<br>
				</div>
			</div>
			
			
			<div class="control-group" style="margin-top: 20px">
				<!-- Button -->
				<div class="controls">
					<form:button class="btn btn-success">Registrar</form:button>
				</div>
			</div>

		</fieldset>
	</form:form>

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>