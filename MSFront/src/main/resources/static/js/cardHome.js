function authReady()
{
	console.log("auth ready");
	$("#userNameId").text(user.name);
}

$(document ).ready(function(){
    $("#playButtonId").click(function(){
    	window.location.assign('/room/roomList.html');
    });    
    $("#buyButtonId").click(function(){
    	
    	window.location.assign('/cardList.html');
    });    
    $("#sellButtonId").click(function(){
    	
    	window.location.assign('/cardList.html');
    });    
});

