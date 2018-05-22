package com.cardgame.services;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.cardgame.controler.CardDao;
import com.cardgame.model.CardModel;
import com.cardgame.utils.Tools;

@Path("/servicescard")
public class UserServices {
	private CardDao dao;
	
	@Context
	ServletContext context;
	
	public UserServices() {
	}

	/**
	 * requête HTTP GET qui renvoie une liste de cartes 
	 * en utilisant le chemin d'URL /cards
	 *
	 * @return String 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cards")
	public String getCards() {
		getDao();
		String cardsJson=this.dao.getCardsJson();	
		return cardsJson;
		
	}
	
	/**
	 * requête HTTP GET qui renvoie une carte 
	 * en fonction de l'ID passé en param
	 * en utilisant le chemin d'URL /cards/{cardID} 
	 * 
	 * @parma String
	 * @return String
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/card/{cardId}")
	public String getCardById(
			@PathParam("cardId") String cardId) {
		getDao();
		return Tools.toJsonString(this.dao.getCard(cardId));
	}
	
	/**
	 * requête HTTP GET qui renvoie une carte 
	 * en fonction du nom passé en param
	 * en utilisant un paramètre d'URL /find?name=nomCarte
	 * 
	 * @param String
	 * @return String
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find")
	public String findCard(@QueryParam("name") String cardName) {
		getDao();
		String jsonCard=Tools.toJsonString(this.dao.getCardByName(cardName));
		return jsonCard;
	}
	
	/**
	 * requête HTTP POST qui crée une carte 
	 * et l'ajoute en base de données
	 *  
	 *  @param CardModel
	 *  @return String
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public String findCard(CardModel newCard) {
		getDao();
		this.dao.addCard(newCard);
		return "{'request:'success'}";
	}
	
	/**
	 * Méthode permettant de récupérer l'objet Dao 
	 * ou d'en créant un si inexistant
	 *  
	 * @return CardDao 
	 */
	public CardDao getDao(){
		if(context.getAttribute("DAO")!=null){
			this.dao=(CardDao)context.getAttribute("DAO");
		}else{
			this.dao=new CardDao();
			context.setAttribute("DAO",this.dao);
		}
		return this.dao;
	}

}
