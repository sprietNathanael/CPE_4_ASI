package com.cpe.springboot.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.springboot.card.model.Card;

@RestController
public class CardRestController {
	
	@Autowired
	private CardService cardService;
	
	@RequestMapping(path="/cards", produces="application/json")
	private List<Card> getAllCourses() {
		return cardService.getAllCards();
	}
	@RequestMapping(path="/cards/{id}", produces="application/json")
	private Card getCard(@PathVariable String id) {
		return cardService.getCard(id);

	}
	@RequestMapping(path="/cards/user/{id}", produces="application/json")
	private List<Card> getCardsUser(@PathVariable String id) {
		return cardService.getCardsUser(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/cards", consumes = "application/json")
	public void addCard(@RequestBody Card card) {
		cardService.addCard(card);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/cards/{id}", consumes = "application/json")
	public void updateCard(@RequestBody Card card,@PathVariable String id) {
		card.setId(Integer.valueOf(id));
		cardService.updateCard(card);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/cards/sell", consumes = "application/json")
	public void sellcard(@RequestBody Card card) {
		card.setIduser(null);
		cardService.updateCard(card);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/cards/buy/{idUser}", consumes = "application/json")
	public void buycard(@RequestBody Card card, @PathVariable Integer idUser) {
		card.setIduser(idUser);
		cardService.updateCard(card);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/cards/{id}")
	public void deleteCard(@PathVariable String id) {
		cardService.deleteCard(id);
	}

}
