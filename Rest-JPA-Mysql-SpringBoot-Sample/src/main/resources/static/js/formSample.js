console.log("formSample.js load");

$("#submit").click(function(){
	var formData = {
			name: $('[name="name"]').val(),
			surname: $('[name="surname"]').val(),
			password: $('[name="password"]').val()
	}
	$.ajax({
		type: "POST",
		contentType : "application/json",
		url: "/users",
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
