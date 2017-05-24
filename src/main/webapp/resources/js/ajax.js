$(document).ready(function() {
	$('#search').keyup(function() {
	   $.ajax({ url: '/mercadoOculto/home/filterByName' , 
	           data:{ filter: $('#search').val() }
	   		 }).done(function(result){
		   			$('#products-display').html(result);
		   });
	});
});