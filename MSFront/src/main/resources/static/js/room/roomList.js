function authReady()
{
	console.log("auth ready");
	$("#userNameId").text(user.name);
}


$(document ).ready(function(){
    /*for(i=0;i<5;i++){
        addRoomToList(i,"room "+ i,"user" +i, 500);
    }*/
    
     $("#createRoomButtonId").click(function(){
     	window.location.replace('/room/createRoom.html');
    }); 
    
});

$(window).on('load', function(){ 
	$.ajax({
		type: "GET",
		contentType : "application/json",
		url: "/rooms/pending"+completeURLWithToken(),
		success: function(data){
			$.each(data, function(index, room){
				addRoomToList(room.id, room.roomName,"user" +room.creatorId, room.bet);
			});
		}, 
		error : function(){
			console.log('Echec');
		}
	});
});

function addRoomToList(id,name, user, bet){
    
    content="<td> "+name+" </td> \
                            <td> "+user+" </td> \
                            <td> "+bet+" $</td> \
                            <td> \
                                <div class='center aligned'> \
                                    <div class='ui  vertical animated button' tabindex='0' onClick='onRoomSelected("+id+")'> \
                                        <div class='hidden content'>Play</div> \
                                        <div class='visible content'> \
                                            <i class='play circle icon'></i> \
                                        </div> \
                                    </div> \
                                </div> \
                            </td>";
    
    $('#roomListId tr:last').after('<tr>'+content+'</tr>');
};

function onRoomSelected(id){
	$.ajax({
		type: "GET",
		contentType : "application/json",
		url: "/rooms/"+ id +completeURLWithToken(),
		dataType: "json",
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
}