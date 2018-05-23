function authReady()
{
	console.log("auth ready");
	$("#userNameId").text(user.name);
}

$(document ).ready(function(){
    $("#playButtonId").click(function(){
        alert("Play button clicked ");
        //TO DO
    });    
    $("#buyButtonId").click(function(){
        alert("Buy button clicked ");
        //TO DO
    });    
    $("#sellButtonId").click(function(){
        alert("Sell button clicked ");
        //TO DO
    });    
});

