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
		url: "users/tryToken?id="+id+"&token="+token,
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
		url: "users/logout?id="+user.id+"&token="+user.token,
		success: function(data){
			sessionStorage.removeItem("user");
			canNotAuthentify();
		}, 
		error : function(){
			console.log('Echec');
		}
	});
}

function completeURLWithToken()
{
	return "?id="+user.id+"&token="+user.token;
}