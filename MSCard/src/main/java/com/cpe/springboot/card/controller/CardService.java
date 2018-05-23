package com.cpe.springboot.card.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.springboot.card.model.Card;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;

	public List<Card> getAllCards() {
		List<Card> cards = new ArrayList<>();
		cardRepository.findAll().forEach(cards::add);
		return cards;
	}

	public Card getCard(String id) {
		return cardRepository.findOne(Integer.valueOf(id));
	}

	public void addCard(Card card) {
		cardRepository.save(card);
	}

	public void updateCard(Card card) {
		cardRepository.save(card);

	}

	public void deleteCard(String id) {
		cardRepository.delete(Integer.valueOf(id));
	}

	public List<Card> getCardsUser(String id) {
		return cardRepository.cardsuser(Integer.valueOf(id));		
	}

/*	public List<Card> getCardByColor(String color) {
		return cardRepository.findByColor(color);
	}*/

}
