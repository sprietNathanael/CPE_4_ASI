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
		success: function(data){
			console.log('Success !!');
		}, 
		error : function(data){
			console.log('Echec');
		}
	});
});

$("#cancel").click(function(){
	window.location.assign('/connexion.html');
});

