$(document).ready(function() {
	$('#searchProducts').keyup(function() {
	   $.ajax({ url: '/mercadoOculto/home/products/filterByName' , 
	           data:{ filter: $('#searchProducts').val(),
	        	      productsToBeListed: $('#orderingSelect').val()
	           }
	   		 }).done(function(result){
		   			$('#products-display').html(result);
		   });
	});
	
	$('#searchButtonProducts').click(function() {
		   $.ajax({ url: '/mercadoOculto/home/products/filterByName' , 
			   	data:{ filter: $('#searchProducts').val(),
	        	      productsToBeListed: $('#orderingSelect').val()
			   	}
		   		 }).done(function(result){
			   			$('#products-display').html(result);
			   });
		});
	

	$('#searchVendors').keyup(function() {
	   $.ajax({ url: '/mercadoOculto/home/view-all-vendors/filterByName' , 
	           data:{ filter: $('#searchVendors').val(),
	        	       orderDisplay: $('#orderingSelect').val()
	           }
	   		 }).done(function(result){
		   			$('#products-display').html(result);
		   });
	});
	
	$('#searchButtonVendors').click(function() {
		   $.ajax({ url: '/mercadoOculto/home/view-all-vendors/filterByName' , 
		           data:{ filter: $('#searchVendors').val(),
		        	       orderDisplay: $('#orderingSelect').val()
		           }
		   		 }).done(function(result){
			   			$('#products-display').html(result);
			   });
	});
	
	
});