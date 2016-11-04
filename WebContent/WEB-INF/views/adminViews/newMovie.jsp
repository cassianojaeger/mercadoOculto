<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp"></jsp:include>
<title>Mega Filmes IMDb</title>
<!-- CSS -->
<!-- CSS -->
<!-- CSS -->
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
<!-- CSS -->
<!-- CSS -->
<!-- CSS -->

</head>
<body>

	<form:form class="form-horizontal" modelAttribute="movie"
		servletRelativeAction="/admconsole/registermovie?${_csrf.parameterName}=${_csrf.token}" 
		method="POST"
		enctype="multipart/form-data">
		<fieldset style="width: 50%; margin: 0 auto">
			<label><h1>Movie Registration</h1></label>
			<div class="control-group">
				<!-- title -->
				<label class="control-label" for="title">Title</label>
				<div class="controls">
					<form:input path="title" placeholder="" class="form-control" />

					<form:errors class="error" path="title" />
				</div>
			</div>
			<div class="control-group">
				<!-- releaseDate -->
				<label class="control-label" for="releaseDate">Release Date</label>
				<div class="controls">
					<form:input path="releaseDate" placeholder="" class="form-control"
						type="datetime-local" />
					<form:errors class="error" path="releaseDate" />
				</div>
			</div>

			<div class="control-group">
				<!-- synopsis -->
				<label class="control-label" for="synopsis">Synopsis</label>
				<div class="controls">
					<form:textarea path="synopsis" placeholder="Synopsis..."
						class="form-control" rows="5" cols="30" />
					<form:errors class="error" path="synopsis" />
					<br>
				</div>
			</div>

			<div class="control-group">
				<!-- length-->
				<label class="control-label" for="length">Length</label>
				<div class="controls">
					<form:input path="length" placeholder="" class="form-control" />
					<form:errors class="error" path="length" />
				</div>
			</div>

			<div class="control-group">
				<!-- genre-->
				<label class="control-label" for="genre">Genre</label>
				<div class="controls">
					<form:select path="genre" placeholder="" class="form-control"
						items="${genreList}" multiple="true" size="12" />
					<form:errors class="error" path="genre" />
				</div>
			</div>

			<div class="control-group">
				<!-- rating-->
				<label class="control-label" for="rating">Rating</label>
				<div class="controls">
					<form:input path="rating" placeholder="" class="form-control"
						type="number" min="0" max="5" step="0.1" />
					<form:errors class="error" path="rating" />
				</div>
			</div>
			<div class="control-group">
				<!-- 				thumbnail -->
				<label class="control-label" for="thumbnail">Thumbnail URL
					path</label>
				<div class="controls">
					<input	name="file" class="form-control" type="file" />
					<form:errors class="error" path="thumbnail" />
				</div>
			</div>

			<div class="control-group" style="margin-top: 20px">
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