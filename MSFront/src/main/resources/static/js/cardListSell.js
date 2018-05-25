
var currentCard;


function setCashUser(){
	
	user.cash = user.cash + currentCard.price;
	console.log(user.cash);
}


$(window).on('load', function(){ 
	$.ajax({
		type: "GET",
		contentType : "application/json",
		url: "/cardsuser/" + user.id,
		success: function(data){
			console.log('OK');
			console.log(data);
			currentCard = data[0];
			$.each(data, function(i, card){
				addCardToList(card.id,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png",card.family,card.imgUrl,card.name,card.description,card.hp,card.energy,card.attack,card.defence,card.price);
			});			
			fillCurrentCard(currentCard.id,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png",currentCard.family,currentCard.imgUrl,currentCard.name,currentCard.description,currentCard.hp,currentCard.energy,currentCard.attack,currentCard.defence,currentCard.price);
		}, 
		error : function(){
			console.log('Echec');
		}
	});
});

$("#sellBtn").click(function(){
	
	console.log(currentCard);
	
		//Delete iduser from card
		$.ajax({
		type: "POST",
		contentType : "application/json",
		url: "/sellcard/?idcard="+ currentCard.id,
		data: JSON.stringify(currentCard),
		dataType: 'json',
		success: function(){
			console.log('Vente réalisée');
		}, 
		error : function(){
			console.log('Vente Echec');
		}
		});
		
		/*setCashUser();
		//Add price card to cash of user
		$.ajax({
			type: "POST",
			contentType : "application/json",
			url: "/updateUser/id/"+ user.id,
			data: JSON.stringify(user),
			dataType: 'json',
			success: function(){
				console.log('Vente réalisée');
			}, 
			error : function(){
				console.log('Vente Echec');
			}
		});*/
});


$(document ).ready(function(){
    

});

function authReady()
{
	console.log("auth ready");
	$("#userNameId").text(user.name);
}



function fillCurrentCard(idCard,imgUrlFamily,familyName,imgUrl,name,description,hp,energy,attack,defence,price){
    //FILL THE CURRENT CARD
    $('#cardFamilyImgId')[0].src=imgUrlFamily;
    $('#cardFamilyNameId')[0].innerHTML=familyName;
    $('#cardImgId')[0].src=imgUrl;
    $('#cardNameId')[0].innerHTML=name;
    $('#cardDescriptionId')[0].innerHTML=description;
    $('#cardHPId')[0].innerHTML=hp+" HP";
    $('#cardEnergyId')[0].innerHTML=energy+" Energy";
    $('#cardAttackId')[0].innerHTML=attack+" Attack";
    $('#cardDefenceId')[0].innerHTML=defence+" Defence";
    $('#cardPriceId')[0].innerHTML=price+" $";
    $('#cardId')[0].innerHTML=idCard;
    getCurrentCard(idCard,familyName,imgUrl,name,description,hp,energy,attack,defence,price);
   
};

function getCurrentCard(idCard,familyName,imgUrl,name,description,hp,energy,attack,defence,price){

	currentCard.id = idCard;
	currentCard.family = familyName;
	currentCard.imgUrl = imgUrl;
	currentCard.name = name;
	currentCard.description = description;
	currentCard.hp = hp;
	currentCard.energy = energy;
	currentCard.attack = attack;
	currentCard.defence = defence;
	currentCard.price = price;
}

function addCardToList(idCard,imgUrlFamily,familyName,imgUrl,name,description,hp,energy,attack,defence,price){
  
    content="\
    <td> \
    <img  class='ui avatar image' src='"+imgUrl+"'> <span>"+name+" </span> \
   </td> \
    <td>"+description+"</td> \
    <td>"+familyName+"</td> \
    <td>"+hp+"</td> \
    <td>"+energy+"</td> \
    <td>"+attack+"</td> \
    <td>"+defence+"</td> \
    <td>"+price+"$</td>\
    <td>\
        <div onclick=\"fillCurrentCard('"+idCard+"','"+imgUrlFamily+"','"+familyName+"','"+imgUrl+"','"+name+"','"+description+"','"+hp+"','"+energy+"','"+attack+"','"+defence+"','"+price+"')\" class='ui vertical animated button' tabindex='0'>\
            <div class='hidden content'>Sell</div>\
    <div class='visible content'>\
        <i class='shop icon'></i>\
    </div>\
    </div>\
    </td>";

    $('#cardListId tr:last').after('<tr>'+content+'</tr>');
    
    
};