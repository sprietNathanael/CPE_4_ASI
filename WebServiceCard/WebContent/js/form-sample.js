$("#form").submit(function(e){ 
	// récupération des données du formulaire submité
	var formData = {
			name: $('[name="name"]').val(),
			description: $('[name="description"]').val(),
			family: $('[name="family"]').val(),
			hp: $('[name="hp"]').val(),
			energy: $('[name="energy"]').val(),
			attack: $('[name="attack"]').val(),
			defence: $('[name="defence"]').val(),
			imgUrl: $('[name="imgUrl"]').val()
	}
	// AJAX appel du web service 
	$.ajax({
		type: "POST",
		contentType : "application/json",
		url: "/WebServiceCard/rest/servicescard/add",
		data: JSON.stringify(formData),
		dataType: 'json',
		success: function(){
			console.log('Success !!');
		}, 
		error : function(){
			console.log('Echec');
		}
	});
});
