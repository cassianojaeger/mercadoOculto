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
<body onload="total_value()">

<div  style="height: 70%">
	<form:form
		servletRelativeAction="/user/confirmPurchase/${cart.id}"
		method="POST"
		modelAttribute="cart">
		<c:set var="cardCVC" />
		<c:set var="cardNumber" />
		<c:set var="itemQuantity" />
		<table class="table table-hover" style="width: 60%; margin: auto;">
			<thead>
				<tr>
					<th></th>
					<th>Product ID</th>
					<th>Nome</th>
					<th>Descri��o</th>
					<th>Pre�o</th>
					<th>Quantidade dispon�vel</th>
					<th>Quantidade a comprar</th>
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
					<td id="cartPrice">${cart.price}</td>	
					<th>${cart.stockQuantity} units</th>	
					<td >
						<div class="controls">
							<input id="cartQuantity" oninput="total_value()" name="itemQuantity" placeholder="Stock Quantity..." class="form-control" type="number" value="1" />
							<br>
						</div>
					</td>		
				</tr>		
			</tbody>
			
		</table>
		<jsp:include page="creditCard.jsp"></jsp:include>
	</form:form>
</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>

<script type="text/javascript"
	src="<c:url value="/resources/js/credit.js"/>"></script>
<link href="<c:url value="/resources/css/credit.css"/>" rel="stylesheet"
	type="text/css" />
<script>


function total_value(){
    var x = document.getElementById("cartPrice").innerHTML;
    var y = document.getElementById("cartQuantity").value;
    
    var s = document.getElementById("totalValue");
    s.innerHTML = x*y;
}


</script>