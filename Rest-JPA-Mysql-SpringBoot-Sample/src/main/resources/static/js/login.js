console.log("login.js load");

$("#submit").click(function(){
	$("#loginError").addClass("hidden");
	var formData = {
			surname: $('[name="surname"]').val(),
			password: $('[name="password"]').val()
	}
	$.ajax({
		type: "GET",
		contentType : "application/json",
		url: "/login?surname="+formData.surname+"&password="+formData.password,
		success: function(data){
			if(data)
			{
				sessionStorage.setItem('token', data);
				sessionStorage.setItem('user', formData.surname);
				window.location = "/cardHome.html";
			}
			else
			{
				$("#loginError").removeClass("hidden");			
			}
		}, 
		error : function(){
			console.log('Echec');
		}
	});
	return false;
});

