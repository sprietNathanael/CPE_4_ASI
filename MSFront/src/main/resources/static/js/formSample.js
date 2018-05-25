function authReady()
{
	console.log("auth ready");
}

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
		url: "/users"+completeURLWithToken(),
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

$("#cancel").click(function(){
	window.location.assign('/connexion.html');
});

