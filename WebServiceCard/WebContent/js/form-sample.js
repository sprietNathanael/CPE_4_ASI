console.log('Hello world');

$("#submit").click(function(e){
	$.ajax({
		url : '/add',
		type : 'POST',
		data: $(this).serialize(),
		success : function(data){
			console.log('success');
		},
		error : function(resultat, statut, erreur){
			console.log('error');console.log(erreur);
		}
	});
});