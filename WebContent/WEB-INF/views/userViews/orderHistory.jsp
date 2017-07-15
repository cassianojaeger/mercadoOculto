
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="<c:url value="/resources/css/movielist.css"/>" rel="stylesheet"
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
									<input id="rating${order.orderModel.id}" placeholder="Nota do vendedor" class="form-control" type="number" value="1" min="0" max="5"  />
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
$(document).ready(function() {
	$("button").click(function() {
	    var orderId = this.id;
	    var orderIdParsed = orderId.replace( /^\D+/g, '');
		 var inputId = "#".concat("rating".concat(orderIdParsed));
	    
	    $.ajax({ url: '/mercadoOculto/user/orderHistory/rate' , 
	        data:{ 
	        			rating:       $(inputId).val(),
	        			orderModelId: orderIdParsed
	        		 }
			 });
	    
	    	$('#'+orderId).remove();
			$(inputId).remove();
			$('#avaliado'+orderIdParsed).html('<label>Vendedor já avaliado</label>');
	});
});
</script>
