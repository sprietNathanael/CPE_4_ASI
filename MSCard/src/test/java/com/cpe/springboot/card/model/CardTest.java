package com.cpe.springboot.card.model;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpe.springboot.card.controller.CardRepository;
import com.cpe.springboot.card.model.Card;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CardTest {
	
	/*@Autowired
	private CardRepository cardRepository;

	 @Test
	    public void createCard() {
		 cardRepository.save(new Card("jo", "blue", "super blue", "https:\\\\fakeSite\\data.jpg"));
		 List<Card> cardList= cardRepository.findByColor("blue");
		 assertTrue(cardList.size() ==1);
		 assertTrue(cardList.get(0).getName().equals("jo"));
	    }*/
}
