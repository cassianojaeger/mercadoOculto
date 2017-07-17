<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="<c:url value="/resources/css/movielist.css"/>" rel="stylesheet"
	type="text/css" />
	
<jsp:include page="../header.jsp"></jsp:include>
<html>
<head>
</head>
<body>
	<div class="panel panel-default" style="width: 80%; margin: 0 auto">
		<!-- Default panel contents -->
		<div class="panel-heading">
			<h2>Order de numero: ${orderData.orderModel.id}</h2>
		</div>
		<div class="panel-body" style="position: relative">
			<p>
				<img class="media-object img-rounded img-responsive"
					src="<c:url value="${orderData.productsInOrder.thumbnail}"/>"
					style="float: left; height: 168px; width: 168px">
			</p>
			<div style="margin-left: 17%; max-width: 80%;">
				<h3>Descrição do item mágico</h3>
				<p>${orderData.productsInOrder.description}</p>
			</div>
			
		</div>

		<!-- List group -->
		<ul class="list-group">
			<li class="list-group-item">Nome do produto: ${orderData.productsInOrder.name}</li>
			<li class="list-group-item">Lista de requisitos(Vendedor): ${orderData.productsInOrder.requirementsList}</li>
			<li class="list-group-item">Lista de requisitos(Usuario): ${orderData.orderModel.requirementList}</li>
			<li class="list-group-item">Tempo de espera: ${orderData.productsInOrder.waitingTime}</li>
			<li class="list-group-item">Vendedor: <a href="<c:url value="/user/profile/${orderData.productsInOrder.owner.id}"/>" >${orderData.productsInOrder.owner.name}</a></li>
			<li class="list-group-item">Comprador: <a href="<c:url value="/user/profile/${orderData.orderModel.product_buyer_id}"/>" >${orderData.productBuyerName}</a></li>
			<li class="list-group-item">Preço: R$ ${orderData.orderModel.totalValue}</li>
		</ul>
	</div>
	<div style="bottom: 10px; float: right; margin-right: 10%; padding-top: 25px">
			
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>