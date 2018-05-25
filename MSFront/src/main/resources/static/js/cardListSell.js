function authReady()
{
	console.log("auth ready");
	$("#userNameId").text(user.name);
	$("#userCash").text(user.cash);
}

var currentCard;
var cards = [];

function setCashUser(){
	
	user.cash = user.cash + cards[currentCard].price;
	$("#userCash").text(user.cash);
	console.log(user.cash);
}

$(window).on('load', function(){ 
	$.ajax({
		type: "GET",
		contentType : "application/json",
		url: "/cards/user/" + user.id+ ""+completeURLWithToken(),
		success: function(data){
			console.log('OK');
			console.log(data);
			$.each(data, function(index, card){
				addCardToList(index,card.id,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png",card.family,card.imgUrl,card.name,card.description,card.hp,card.energy,card.attack,card.defence,card.price);
				cards.push(card);
			});
			currentCard = 0;
			fillCurrentCard();
		}, 
		error : function(){
			console.log('Echec');
		}
	});
});

$("#sellBtn").click(function(){
	
	
		//Delete iduser from card
		$.ajax({
		type: "POST",
		contentType : "application/json",
		url: "/cards/sell/"+ completeURLWithToken(),
		data: JSON.stringify(cards[currentCard]),
		dataType: 'json',
		success: function(){
			console.log('Vente réalisée');
		}, 
		error : function(){
			console.log('Vente Echec');
		}
		});
		
		setCashUser();
		//Add price card to cash of user
		$.ajax({
			type: "PUT",
			contentType : "application/json",
			url: "/users/"+ user.id + completeURLWithToken() ,
			data: JSON.stringify(user),
			dataType: 'json',
			success: function(){
				console.log('Vente réalisée');
			}, 
			error : function(){
				console.log('Vente Echec');
			}
		});
		
		location.reload();
});


function fillCurrentCard(){
	//FILL THE CURRENT CARD
    $('#cardFamilyImgId')[0].src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png";
    $('#cardFamilyNameId')[0].innerHTML=cards[currentCard].family;
    $('#cardImgId')[0].src=cards[currentCard].imgUrl;
    $('#cardNameId')[0].innerHTML=cards[currentCard].name;
    $('#cardDescriptionId')[0].innerHTML=cards[currentCard].description;
    $('#cardHPId')[0].innerHTML=cards[currentCard].hp+" HP";
    $('#cardEnergyId')[0].innerHTML=cards[currentCard].energy+" Energy";
    $('#cardAttackId')[0].innerHTML=cards[currentCard].attack+" Attack";
    $('#cardDefenceId')[0].innerHTML=cards[currentCard].defence+" Defence";
    $('#cardPriceId')[0].innerHTML=cards[currentCard].price+" $";
    $('#cardId')[0].innerHTML=cards[currentCard].id;
   
};

function updateCurrentCard(cardIndex){
	currentCard = parseInt(cardIndex);
	fillCurrentCard();

}


function addCardToList(index,idCard,imgUrlFamily,familyName,imgUrl,name,description,hp,energy,attack,defence,price){
  
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
        <div onclick=\"updateCurrentCard("+index+")\" class='ui vertical animated button' tabindex='0'>\
            <div class='hidden content'>Sell</div>\
    <div class='visible content'>\
        <i class='shop icon'></i>\
    </div>\
    </div>\
    </td>";

    $('#cardList').append('<tr>'+content+'</tr>');
    
    
};