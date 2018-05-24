function authReady()
{
	console.log("auth ready");
	$("#userNameId").text(user.name);
}

$(document ).ready(function(){
    $("#playButtonId").click(function(){
        alert("room/roomList.html");
        //TO DO
    });    
    $("#buyButtonId").click(function(){
    	window.location.replace('/cardList.html');
    });    
    $("#sellButtonId").click(function(){
    	window.location.replace('/cardList.html');
    });    
});

