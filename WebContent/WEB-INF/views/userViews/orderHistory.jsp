
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="<c:url value="/resources/css/movielist.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/star.css"/>" rel="stylesheet"
	type="text/css" />

<jsp:include page="../header.jsp" />
<html>

<!-- PRODUTOS DO USUARIO -->
<div class="container" style="margin-top: 50px; width: 82%">
	<h2>Histórico de compra</h2>
	<p>Abaixo encontra-se todas suas compras</p>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Imagem do produto</th>
				<th>Nome do produto</th>
				<th>Descrição do produto</th>
				<th>Nome do vendedor</th>
				
				<th>Avalie o vendedor</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="order" items="${orderList}">
				<c:if test="${order.productsInOrder.id != null}" >
				<tr>
					<td>
						<div class="post-img-content"
							style="float: left; padding-right: 10px; padding-bottom: 10px">
							<a href="<c:url value="/home/info/${order.productsInOrder.id}"/>"><img
							src="<c:url value="${order.productsInOrder.thumbnail}"/>" class="img-responsive"
							style="width: 100px; height: 100px" /></a>
						</div>
					</td>
					<td>${order.productsInOrder.name}</td>
					<td>${order.productsInOrder.description}</td>
					<td>
						<a href="<c:url value="/user/profile/${order.productsInOrder.owner.id}"/>">
							${order.productsInOrder.owner.name}
						</a>
					</td>
					<c:choose>
						<c:when test="${order.pendentAvaliation == 'yes'}">
							<td>								
								<div class="controls" id="avaliado${order.orderModel.id}">
									<!-- <input id="rating${order.orderModel.id}" placeholder="Nota do vendedor" class="form-control" type="number" value="1" min="0" max="5"  /> -->
									<div class="stars">
										  <form action="">
										    <input class="star star-5" id="star-5" type="radio" name="star"/>
										    <label class="star star-5" for="star-5"></label>
										    <input class="star star-4" id="star-4" type="radio" name="star"/>
										    <label class="star star-4" for="star-4"></label>
										    <input class="star star-3" id="star-3" type="radio" name="star"/>
										    <label class="star star-3" for="star-3"></label>
										    <input class="star star-2" id="star-2" type="radio" name="star"/>
										    <label class="star star-2" for="star-2"></label>
										    <input class="star star-1" id="star-1" type="radio" name="star"/>
										    <label class="star star-1" for="star-1"></label>
										  </form>
									</div>
								<br>
								</div>
								
								<button id="button${order.orderModel.id}" type="submit" class="btn btn-default btn-sm btn-primary" style="float: right; margin-right: 20%; margin-top: 80px">
									<h4>Checkout</h4>
								</button>
									
							</td>
						</c:when>
						<c:otherwise>
							<td><label id="vendor_rating">Vendedor já avaliado</label></td>
						</c:otherwise>
					</c:choose>
				</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="../footer.jsp"></jsp:include>
</html>
<script>
var starId;
var starRate;
$(document).ready(function() {
	$("button").click(function() {
		 
	    var buttonId = this.id;
	    var orderId = buttonId.replace( /^\D+/g, '');
	    
	    $.ajax({ url: '/mercadoOculto/user/orderHistory/rate' , 
	        data:{ 
	        			rating:       starRate,
	        			orderModelId: orderId
	        		 }
			 });
	    
	    	$('#'+buttonId).remove();
	    	$('#avaliado'+orderId).empty();
			$('#avaliado'+orderId).html('<label>Vendedor já avaliado</label>');
	});
});

$('input').click(function(){
	starId = this.id;
	starRate = starId.replace( /^\D+/g, '');
});
</script>
