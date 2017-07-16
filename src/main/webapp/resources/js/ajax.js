$(document).ready(function() {
	$('#search').keyup(function() {
	   $.ajax({ url: '/mercadoOculto/home/products/filterByName' , 
	           data:{ filter: $('#search').val() }
	   		 }).done(function(result){
		   			$('#products-display').html(result);
		   });
	});
	

	$('#search1').keyup(function() {
	   $.ajax({ url: '/mercadoOculto/home/view-all-vendors/filterByName' , 
	           data:{ filter: $('#search1').val() }
	   		 }).done(function(result){
		   			$('#products-display').html(result);
		   });
	});
});