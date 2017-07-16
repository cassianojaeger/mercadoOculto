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
			<h2>Procure por vendedores</h2>
			<div id="custom-search-input">
				<div class="input-group col-md-12">
					<input type="text" class="  search-query form-control"
						placeholder="Search" id="searchVendors" /> <span class="input-group-btn">
						<button class="btn btn-danger" type="button" id="searchButtonVendors">
							<span class=" glyphicon glyphicon-search"></span>
						</button>
					</span>
					
				</div>
			</div>
		</div>
		<div class="form-group" style="margin-left: -15px">
		  <label for="sel1">Ordene por avalia��es</label>
		  <select class="form-control" id="orderingSelect" style="width: 15%">
		  	 <option value="ASC">Menor Avalia��o</option>
		    <option value="DESC">Maior Avalia��o</option>
		  </select>
		</div>
	</div>
	<div class="container" id="products-display">
		<jsp:include page="vendors-grid.jsp"></jsp:include>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</html>
