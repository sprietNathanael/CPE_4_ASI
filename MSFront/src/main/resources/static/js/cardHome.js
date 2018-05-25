function authReady()
{
	console.log("auth ready");
	$("#userNameId").text(user.name);
}

$(document ).ready(function(){
    $("#playButtonId").click(function(){
    	window.location.replace('/room/roomList.html');
    });    
    $("#buyButtonId").click(function(){
    	window.location.replace('/cardListBuy.html');
    });    
    $("#sellButtonId").click(function(){
    	window.location.replace('/cardListSell.html');
    });    
});

