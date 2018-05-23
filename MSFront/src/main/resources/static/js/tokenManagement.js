var sessionUser = sessionStorage.getItem('user');
var user;
if(sessionUser !== undefined && sessionUser !== null)
{
	try {
		user = JSON.parse(sessionUser);
	} catch (e) {
		canNotAuthentify();
	}
	
	console.log("user = ");
	console.log(user)
	tryToken(user.id, user.token, function(){console.log("authentifié")});
}
else
{
	canNotAuthentify();
}

function tryToken(id, token)
{
	$.ajax({
		type: "GET",
		contentType : "application/json",
		url: "/tryToken?id="+id+"&token="+token,
		success: function(data){
			if(data)
			{
				console.log("authentifié");
				authReady();
			}
			else
			{
				canNotAuthentify();
			}
		}, 
		error : function(){
			console.log('Echec');
		}
	});
}

function canNotAuthentify()
{
	window.location = "/connexion.html";
}

function logout()
{
	$.ajax({
		type: "GET",
		contentType : "application/json",
		url: "/logout?id="+user.id,
		success: function(data){
			sessionStorage.removeItem("user");
			canNotAuthentify();
		}, 
		error : function(){
			console.log('Echec');
		}
	});
}