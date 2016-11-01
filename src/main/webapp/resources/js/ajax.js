$(document).ready(function() {
	$('#search').keyup(function() {
		$.ajax({
			url : '/imdb/home/filterByName',
			data : {
				filter : $('#search').val()
			}
		}).done(function(result) {
			$('#movies-display').html(result);
		});
	});
});