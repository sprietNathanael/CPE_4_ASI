function authReady()
{
	console.log("auth ready");
	$("#userNameId").text(user.name);
}

$(document).ready(function(){
    $("#cancelButtonId").click(function()
    	window.location.replace('/room/roomList.html');
    });  
    
    $("#createButtonId").click(function(){
        alert("Search button clicked :"+$("#roomBetId").val());
        //TO DO
    }); 
    
    
});