<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="<c:url value="/resources/css/movielist.css"/>" rel="stylesheet"
	type="text/css" />

<jsp:include page="../header.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js"/>"></script>

<html>
	<div style="width: 70%; margin: 0 auto 10px auto">
		<div class="row">
			<h2>Procure por feitiços e itens mágicos</h2>
			<div id="custom-search-input">
				<div class="input-group col-md-12">
					<input type="text" class="  search-query form-control"
						placeholder="Search" id="search" /> <span class="input-group-btn">
						<button class="btn btn-danger" type="button">
							<span class=" glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
		</div>
	</div>
	<div class="container" id="products-display">
		<jsp:include page="products-grid.jsp"></jsp:include>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</html>
