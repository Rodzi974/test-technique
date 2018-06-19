$(function(){

	$(':button').click(function() {
		$('.alert').remove();
		var $this = $(this);
		$.ajax({
			url : '/calculerTaxes/',
			type : 'GET',
			data : {produitId : $this.data('produit-id')}
		}).done(function(data) {
			$this.after('<span class="alert-success pull-right">' + data + '€</span>');
		}).fail(function() {
			$this.after('<span class="alert-danger pull-right">Erreur</span>');
		});
	});
		
});
