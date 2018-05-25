function authReady()
{
	$("#userNameId").text(user.name);
}

function checkPlayersReady(room){
	$.ajax({
		type: "GET",
		contentType : "application/json",
		url: "/rooms/" + room.id + completeURLWithToken(),
		dataType: "json",
		success: function(data){
			if (data.state == 1){
				window.location.assign('/room/selectCardForPlay.html');
			}
		}, 
		error : function(){
			console.log('Echec');
		}
	});
}

function addPlayer(room, user){
	$.ajax({
		type: "GET",
		contentType : "application/json",
		url: "/rooms/" + room.id + "/addPlayer/" + user.id + completeURLWithToken(),
		dataType: "json"
	});
}

var sessionRoom = sessionStorage.getItem('room');
var room;

if(sessionRoom !== undefined && sessionRoom !== null){
	room = JSON.parse(sessionRoom);
	//Ajout du joueur à la room
	addPlayer(room, user);
	//Attente des deux joueurs pour accéder à la room
	setInterval(function(){checkPlayersReady(room);}, 1000);
} else {
	window.location.assign('/room/roomList.html');
}