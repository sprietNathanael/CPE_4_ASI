package com.cpe.springboot.card.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpe.springboot.card.controller.CardRepository;
import com.cpe.springboot.card.model.Card;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CardTest {

	@Autowired
	private CardRepository cardRepository;

	@Test
	public void createCard() {
		String name = "Pélican";
		cardRepository.save(new Card(name,"Pélican dorée","Oiseau", 10, 50, 20, 5, "http://www.pelican.png"));
		List<Card> listCard = new ArrayList<Card>();
		cardRepository.findAll().forEach(listCard::add);
		
		assertNotNull(listCard);
		for(Card card : listCard)
		{
			if(card.getName() == name)
			{
				Card u = cardRepository.findOne(card.getId());
				assertNotNull(u);
			}
		}
	}

	@Test
	public void findOne() {
		int id = 1;
		String name = "Blue Dragon";
		Card card = cardRepository.findOne(id);
		assertTrue(card != null);
		assertTrue(card.getId().equals(id));
		assertTrue(card.getName().equals(name));
	}

	@Test
	public void findAllCard() {

		String name = "Pélican";

		List<Card> cards = new ArrayList<Card>();
		cardRepository.findAll().forEach(cards::add);
		int sizebeforeinsert = cards.size();

		for (int i = 0; i < 10; i++) {
			cardRepository.save(new Card(name + i,"Pélican dorée","Oiseau", 10, 50, 20, 5, "http://www.pelican.png"));
		}

		cards.clear();
		cardRepository.findAll().forEach(cards::add);
		int sizeafterinsert = 10 + sizebeforeinsert;
		assertTrue(cards.size() == (sizeafterinsert));

		for (int i = sizebeforeinsert; i < 10; i++) {
			String nameCard = cards.get(i).getName();
			nameCard.split(name);
			int index = Integer.valueOf(nameCard.split(name)[1]);
			assertTrue(cards.get(i).getName().equals(name + index));
		}
	}

	@Test
	public void delete() {

		int id = 1;

		Card card = cardRepository.findOne(id);
		assertTrue(card != null);
		cardRepository.delete(id);

		card = cardRepository.findOne(id);
		assertTrue(card == null);
	}
}
