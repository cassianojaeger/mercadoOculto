<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="<c:url value="/resources/css/movielist.css"/>"
	rel="stylesheet" type="text/css" />
<style>
.no-click {
    pointer-events: none;
}
</style>
<div class="row">
	<c:forEach var="user" items="${users}">
		<div class="col-sm-8 col-md-6"
			style="background-color: #f6f6f5; border: #fff 1px solid;">
			<div class="post">

				<!-- vendor Image and link -->
				<div class="post-img-content"
					style="float: left; padding-right: 10px; padding-bottom: 10px">
				<a href="<c:url value="/user/profile/${user.id}"/>">
					<c:choose>
						<c:when test="${user.userTypes == 'BRUXO'}">
							<img class="media-object img-rounded img-responsive"
							src="<c:url value="/resources/uploaded-thumbnails/bruxo.png"/>"
							style="float: left; height: 168px; width: 168px">
						</c:when>
						<c:when test="${user.userTypes == 'NORMAL'}">
							<img class="media-object img-rounded img-responsive"
							src="<c:url value="/resources/uploaded-thumbnails/normal.png"/>"
							style="float: left; height: 168px; width: 168px">
						</c:when>
						<c:when test="${user.userTypes == 'MODERADOR'}">
							<img class="media-object img-rounded img-responsive"
							src="<c:url value="/resources/uploaded-thumbnails/moderador.png"/>"
							style="float: left; height: 168px; width: 168px">
						</c:when>
					</c:choose>
				</a>
				</div>
	
				<div class="content">
					<a href="<c:url value="/user/profile/${user.id}"/>"> <span
						class="post-title"> <b>
								<h4>${user.name}</h4>
						</b>
					</span>
					</a>
					<div class="product_description">
						<small style="color: #666666"> 
							<b><br>
								<button type="button" class="btn btn-sucess no-click">
									Avaliação 
									<span class="badge ">
										${user.vendorGrade}
									</span>
								</button> 						
						</b>
					</div>
					<div class="product_price" >
						<small style="color: #666666"> <b>E-mail: ${user.email} </b>
					</div>
				</div>
				<!-- End of Product Title and description -->
			</div>
		</div>
	</c:forEach>
</div>

<script>

</script>