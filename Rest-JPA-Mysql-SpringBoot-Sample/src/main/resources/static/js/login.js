console.log("login.js load");

$("#submit").click(function(){
	var formData = {
			surname: $('[name="surname"]').val(),
			password: $('[name="password"]').val()
	}
	$.ajax({
		type: "GET",
		contentType : "application/json",
		url: "/login",
		data: JSON.stringify(formData),
		dataType: 'json',
		success: function(data){
			console.log(data);
		}, 
		error : function(){
			console.log('Echec');
		}
	});
});

