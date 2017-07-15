	
	<!-- <div id="commentDiv" style="width: 90%; margin: 50px auto;">
		<sec:authorize access="isAuthenticated()">			
			<form:form servletRelativeAction="/user/comment/${magicService.id}"
				method="POST">
				<h2>Comment session</h2>
				<input name="comment" id="comment"
					class="form-control"  />
					<br>
				<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i>Comente</button>
			</form:form>
		</sec:authorize>
		
		<c:forEach items="${magicService.comments}" var="comment"> 
			<div class="row">
				<div class="col-sm-1">
					<div class="thumbnail">
						<img class="img-responsive user-photo"
							src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
					</div>
					
				</div>
				<div class="col-sm-5">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong>${comment.user}</strong>
						</div>
						<div class="panel-body">${comment.comment}</div>
					</div>
				</div> 
			</div>
		</c:forEach>
	</div> -->