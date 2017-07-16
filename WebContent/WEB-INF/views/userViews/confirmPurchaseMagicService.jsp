<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<jsp:include page="../header.jsp" />
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/js/tablelink.js"/>"></script>
<script src="https://code.jquery.com/jquery-3.1.1.js"
	integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
	crossorigin="anonymous"></script>
	
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.payment/1.2.3/jquery.payment.min.js"></script>

<!-- If you're using Stripe for payments -->
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>	
	
	
</head>
<body>

<div  style="height: 70%">
	<form:form
		servletRelativeAction="/user/confirmPurchase/${cart.id}"
		method="POST"
		modelAttribute="cart">
		
		<c:set var="requirementList" />						
		<table class="table table-hover" style="width: 60%; margin: auto;">
			<thead>
				<tr>
					<th></th>
					<th>Product ID</th>
					<th>Nome</th>
					<th>Descrição</th>
					<th>Preço</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>
						<div class="post-img-content"
						style="float: left; padding-right: 10px; padding-bottom: 10px">
						<a href="<c:url value="/home/info/${cart.id}"/>"><img
							src="<c:url value="${cart.thumbnail}"/>" class="img-responsive"
							style="width: 100px; height: 100px" /></a>
						</div>
					</th>
					<div class="padding-top: 100px">
					<th>${cart.id}</th>
					<td>${cart.name}</td>								
					<td>${cart.description}</td>
					<td>${cart.price}</td>				
				</tr>		
			</tbody>
			
		</table>
		<!-- List group -->
		<ul class="list-group" style="width: 60%; margin: auto;">
			<li class="list-group-item"> <h4 class="panel-title">Lista de requisitos:${cart.requirementsList}</h4><br>
				<div class="controls" style="margin-top: 10px">
					<textarea name="requirementList" placeholder="Lista de Requisitos" class="form-control" type="text" value="Lista de Requisitos"  rows="5" cols="30" >
					</textarea>
					<br>
				</div>
			</li>
		</ul>
		<jsp:include page="creditCard.jsp"></jsp:include>
		
	</form:form>
</div>
</body>
<script type="text/javascript"
	src="<c:url value="/resources/js/credit.js"/>"></script>
<link href="<c:url value="/resources/css/credit.css"/>" rel="stylesheet"
	type="text/css" />
<jsp:include page="../footer.jsp"></jsp:include>
</html>