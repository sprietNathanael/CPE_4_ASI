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
	
	@RequestMapping("/cards")
	private List<Card> getAllCourses() {
		return cardService.getAllCards();

	}
	
	@RequestMapping("/cards/{id}")
	private Card getCard(@PathVariable String id) {
		return cardService.getCard(id);

	}
	
	@RequestMapping(method=RequestMethod.POST,value="/cards")
	public void addCard(@RequestBody Card card) {
		cardService.addCard(card);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/cards/{id}")
	public void updateCard(@RequestBody Card card,@PathVariable String id) {
		card.setId(Integer.valueOf(id));
		cardService.updateCard(card);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/cards/{id}")
	public void deleteCard(@PathVariable String id) {
		cardService.deleteCard(id);
	}
	
	/*@RequestMapping("/cards/color/{color}")
	private List<Card> getAllCourses(@PathVariable String color) {
		return cardService.getCardByColor(color);

	}*/
	

}
