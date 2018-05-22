$('#cardFamilyImgId')[0].src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png";
$('#cardFamilyNameId')[0].innerHTML="DC comics";
$('#cardImgId')[0].src="http://www.guinnessworldrecords.com/images/superlative/superheroes/GWR-Superheroes-SUPERMAN.svg";
$('#cardNameId')[0].innerHTML="SUPERMAN";
$('#cardDescriptionId')[0].innerHTML="The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El, moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass. Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of humanity through a 'Superman' identity.";
$('#cardHPId')[0].innerHTML="50 HP";
$('#cardEnergyId')[0].innerHTML="100 Energy";
$('#cardAttackId')[0].innerHTML="17 Attack";
$('#cardDefenceId')[0].innerHTML="80 Defence";

function submit(){
	var formData = $('[name="name"]').val();
	// AJAX appel du web service 
	$.ajax({
		type: "GET",
		url: "/WebServiceCard/rest/servicescard/find?name=" + $('[name="name"]').val(),		
		success: function(data){
			console.log("success!!");
			$('#cardFamilyImgId')[0].src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png";
			$('#cardFamilyNameId')[0].innerHTML= data.family;
			$('#cardImgId')[0].src= data.imgUrl;
			$('#cardNameId')[0].innerHTML= data.name;
			$('#cardDescriptionId')[0].innerHTML= data.description;
			$('#cardHPId')[0].innerHTML= data.hp;
			$('#cardEnergyId')[0].innerHTML= data.energy;
			$('#cardAttackId')[0].innerHTML= data.attack;
			$('#cardDefenceId')[0].innerHTML= data.defence;
		}, 
		error : function(){
			console.log('Echec');
		}
	});
};


