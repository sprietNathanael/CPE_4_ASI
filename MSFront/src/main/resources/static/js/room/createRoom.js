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
		dataType: "json",
		data: JSON.stringify(formData),
		success: function(data){
			if (data){
				sessionStorage.setItem('room', JSON.stringify(data));
				location.assign("/room/waitPlayer.html");
			}
		}, 
		error : function(data){
			if (data){
				sessionStorage.setItem('room', JSON.stringify(data));
				location.assign("/room/waitPlayer.html");
			}
		}
	});
});