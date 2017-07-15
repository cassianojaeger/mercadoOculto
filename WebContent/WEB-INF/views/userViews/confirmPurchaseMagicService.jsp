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
</head>
<body>

<div  style="height: 70%">
	<form:form class="form-inline"
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
		<div class="panel-group" id="accordion" style="width: 60% !important; margin: auto">
		  <div class="panel panel-default">
		    <div class="panel-heading">
		      <h4 class="panel-title">
		        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
		        Numero do cartão de crédito</a>
		      </h4>
		    </div>
		    <div id="collapse1" class="panel-collapse collapse in">
		      <div class="panel-body">
		      	<input name="creditNumber" placeholder="Numero do cartão" class="form-control" type="text" />
		      </div>
		    </div>
		  </div>
		  <div class="panel panel-default">
		    <div class="panel-heading">
		      <h4 class="panel-title">
		        <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
		        Digitos de segurança do cartão</a>
		      </h4>
		    </div>
		    <div id="collapse2" class="panel-collapse collapse">
		      <div class="panel-body">
		      	<input name="creditSecurity" placeholder="Numero de segurança" class="form-control" type="text" />
		      </div>
		    </div>
		  </div>
		</div>
		<br>
		<hr style="width: 70%; margin: auto; padding-top: 30px">
		<label style="margin-left:70%; font-size: 20px">Total:&nbsp R$ &nbsp<span id="totalValue">${cart.price}</span></label>
		<button type="submit" class="btn btn-default btn-sm btn-primary" style="float: right; margin-right: 20%; margin-top: 10px	">
			<h4>Confirmar Compra</h4>
		</button>
	</form:form>
</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>