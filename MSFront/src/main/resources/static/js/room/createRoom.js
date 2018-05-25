console.log("createRoom.js load");

function authReady()
{
	console.log("auth ready");
	$("#userNameId").text(user.name);
}

$(document).ready(function(){
    $("#cancelButtonId").click(function(){
    	window.location.replace('/room/roomList.html');
    });

    $("#submit").click(function(){
    	$("#loginError").addClass("hidden");
    	var formData = {
    			roomName: $('[name="roomBetId"]').val(),
    			bet: $('[name="roomBetId"]').val(),
    			creatorId: user.id
    	}
    	$.ajax({
    		type: "POST",
    		contentType : "application/json",
    		url: "/create"+completeURLWithToken(),
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
});
