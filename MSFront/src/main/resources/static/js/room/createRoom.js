console.log("createRoom.js load");

function authReady()
{
	console.log("auth ready");
	$("#userNameId").text(user.name);
}

$(document).ready(function(){
    $("#cancelButtonId").click(function(){
    	window.location.assign('/room/roomList.html');
    });
});

$("#submit").click(function(){
	var formData = {
			creatorId: user.id,
			roomName: $('[name="roomName"]').val(),
			bet: $('[name="bet"]').val()
	}
	$.ajax({
		type: "POST",
		contentType : "application/json",
		url: "/rooms"+completeURLWithToken(),
		data: JSON.stringify(formData),
		dataType: 'json',
		success: function(){
			console.log('Success !!');
			location.assign("/room/waitPlayer.html");
		}, 
		error : function(){
			console.log('Echec');
			location.assign("/room/waitPlayer.html");
		}
	});
});