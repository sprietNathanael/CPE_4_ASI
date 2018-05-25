function authReady()
{
	console.log("auth ready");
	$("#userNameId").text(user.name);
	$("#userCash").text(user.cash);
}

$(document ).ready(function(){
    $("#playButtonId").click(function(){
    	window.location.assign('/room/roomList.html');
    });    
    $("#buyButtonId").click(function(){
    	
    	window.location.assign('/cardListBuy.html');
    });    
    $("#sellButtonId").click(function(){
    	
    	window.location.assign('/cardListSell.html');
    });    
});

