<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="<c:url value="/resources/css/movielist.css"/>"
	rel="stylesheet" type="text/css" />

<div class="row">
	<c:forEach var="product" items="${products}">
		<div class="col-sm-8 col-md-6"
			style="background-color: #f6f6f5; border: #fff 1px solid;">
			<div class="post">

				<!-- Product Image and link -->
				<div class="post-img-content"
					style="float: left; padding-right: 10px; padding-bottom: 10px">
					<a href="<c:url value="/home/info/${product.id}"/>"><img
						src="<c:url value="${product.thumbnail}"/>" class="img-responsive"
						style="width: 100px; height: 100px" /></a>
				</div>
				<!-- End of Product Image and link  -->
				<!--  Product Title and description -->
				<div class="content">
					<a href="<c:url value="/home/info/${product.id}"/>"> <span
						class="post-title"> <b>
								<h4>${product.name}</h4>
						</b>
					</span>
					</a>
					<div class="product_description">
						<small style="color: #666666"> <b>${product.description}</b>
					</div>
					<div class="product_price" >
						<small style="color: #666666"> <b>R$ ${product.price} </b>
					</div>
				</div>
				<!-- End of Product Title and description -->
			</div>
		</div>
	</c:forEach>
</div>