$("#form").submit(function(e){ 
	var formData = {
			name: $('[name="name"]').val(),
			description: $('[name="description"]').val(),
			family: $('[name="family"]').val(),
			hp: $('[name="hp"]').val(),
			energy: $('[name="energy"]').val(),
			attack: $('[name="attack"]').val(),
			defence: $('[name="defence"]').val(),
			imageUrl: $('[name="imageUrl"]').val()
	}
	$.ajax({
		type: "POST",
		contentType : "application/json",
		url: "/WebServiceCard/rest/servicescard/add",
		data: JSON.stringify(formData),
		dataType: 'json',
		success: function(e){
			alert('yes');
		}, 
		error : function(e){
			console.log(e);
		}
	});
});
