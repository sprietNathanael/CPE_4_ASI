package com.cpe.springboot.card.controller;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
public class CardServiceTest {
	
	/*@Autowired
	private CardRepository cardRepository;
	
	
	@Test
    public void saveCard() {
		cardRepository.save(new Card("jo", "blue", "super blue", "https:\\\\fakeSite\\data.jpg"));
		List<Card> cards = new ArrayList<>();
		cardRepository.findAll().forEach(cards::add); 
		 assertTrue(cards.size() ==1);
		 assertTrue(cards.get(0).getColor().equals("blue"));
		 assertTrue(cards.get(0).getSuperPower().equals("super blue"));
		 assertTrue(cards.get(0).getImgUrl().equals("https:\\\\fakeSite\\data.jpg"));
	}

	 @Test
	    public void findColorCard() {
		 cardRepository.save(new Card("jo", "blue", "super blue", "https:\\\\fakeSite\\data.jpg"));
		 List<Card> cardList= cardRepository.findByColor("blue");
		 assertTrue(cardList.size() ==1);
		 assertTrue(cardList.get(0).getName().equals("jo"));
	    }
	 
		@Test
	    public void findAllCard() {
			for(int i=0;i<100;i++) {
				cardRepository.save(new Card("jo"+i, "blue"+i, "super blue"+i, "https:\\\\fakeSite\\data"+i+".jpg"));
			}
			
			List<Card> cards = new ArrayList<>();
			cardRepository.findAll().forEach(cards::add); 
			
			assertTrue(cards.size() ==100);
			
			for(int i=0;i<100;i++) {
				String name=cards.get(i).getName();
				name.split("joe");
				int index=Integer.valueOf(name.split("jo")[1]);
				 assertTrue(cards.get(i).getName().equals("jo"+index));
				 assertTrue(cards.get(i).getColor().equals("blue"+index));
				 assertTrue(cards.get(i).getSuperPower().equals("super blue"+index));
				 assertTrue(cards.get(i).getImgUrl().equals("https:\\\\fakeSite\\data"+index+".jpg"));
			}
			
			//TO COMPLETE
			
		}*/
}
