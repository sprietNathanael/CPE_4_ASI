package com.cpe.springboot.card.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cpe.springboot.card.controller.CardRestController;
import com.cpe.springboot.card.controller.CardService;
import com.cpe.springboot.card.model.Card;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CardRestController.class, secure = false)
public class CardRestControllerTest {

	@Autowired
	private CardRestController rest;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CardService cardService;

	Card mockCard;
	List<Card> listCard = new ArrayList<Card>();
	List<Card> cardListUser = new ArrayList<Card>();
	int idCard = 1;

	@Before
	public void setUp() throws Exception {
		mockCard = new Card("Blue Dragon", "Très beau dragon", "Dragon", 100, 100, 100, 20,
				"https://vignette.wikia.nocookie.net/yugioh/images/6/6e/RedEyesDarknessDragon-DG-EN-VG-NC.png");
		mockCard.setId(idCard);
		mockCard.setIduser(2);
		listCard.add(mockCard);
		Card u = new Card("Rose Inoffensive", "Petit fleur", "Fleur", 100, 100, 20, 10,
				"https://i.pinimg.com/originals/5c/03/d0/5c03d0df8135b4ea100ba0c4978ebf16.png");
		u.setId(2);
		u.setPrice(BigDecimal.valueOf(200));
		listCard.add(u);
		Card u2 = new Card("Pume Féroce", "Gros chaton", "Felin", 100, 100, 50, 40,
				"https://www.chausport.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/9/4/9434-chaussures-puma-suede-classic-junior-noire-vue-exterieure.png");
		u2.setId(3);
		u2.setPrice(BigDecimal.valueOf(100));
		listCard.add(u2);
		Card u3 = new Card("Lézard or", "Reptile", "Lézard", 60, 50, 20, 10,
				"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Blazma1.jpg/220px-Blazma1.jpg");
		u3.setId(4);
		u3.setPrice(BigDecimal.valueOf(50));
		u3.setIduser(1);
		listCard.add(u3);
		cardListUser.add(u3);

	}

	@Test
	public void getCard() {
		// Lorsque l'on appelera la méthode getCard avec comme paramètre "1", le mock
		// retournera card
		Mockito.when(cardService.getCard(String.valueOf(idCard))).thenReturn(mockCard);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cards/" + mockCard.getId())
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();

			System.out.println("Result: " + result.getResponse().getContentAsString());
			String expected = "{\"id\":1,\"name\":\"Blue Dragon\",\"description\":\"Très beau dragon\",\"family\":\"Dragon\",\"hp\":100,\"energy\":100,\"attack\":100,\"defence\":20,\"imgUrl\":\"https://vignette.wikia.nocookie.net/yugioh/images/6/6e/RedEyesDarknessDragon-DG-EN-VG-NC.png\",\"price\":null,\"iduser\":2}";

			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getCardUser() {
		// Lorsque l'on appelera la méthode getCardsUser avec comme paramètre "1", le
		// mock
		// retournera les cartes de l'user 1
		Mockito.when(cardService.getCardsUser("1")).thenReturn(cardListUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cards/user/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();

			System.out.println("Result: " + result.getResponse().getContentAsString());
			String expected = "[{\"id\":4,\"name\":\"Lézard or\",\"description\":\"Reptile\",\"family\":\"Lézard\",\"hp\":60,\"energy\":50,\"attack\":20,\"defence\":10,\"imgUrl\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Blazma1.jpg/220px-Blazma1.jpg\",\"price\":50.00,\"iduser\":1}]";

			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getAllCards() throws Exception {

		// Lorsque l'on appelera la méthode getAllCards avec comme paramètre "1", le
		// mock // retournera card
		Mockito.when(cardService.getAllCards()).thenReturn(listCard);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cards").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("Result: " + result.getResponse().getContentAsString());
		String expected = "[{\"id\":1,\"name\":\"Blue Dragon\",\"description\":\"Très beau dragon\",\"family\":\"Dragon\",\"hp\":100,\"energy\":100,\"attack\":100,\"defence\":20,\"imgUrl\":\"https://vignette.wikia.nocookie.net/yugioh/images/6/6e/RedEyesDarknessDragon-DG-EN-VG-NC.png\",\"price\":null,\"iduser\":2},{\"id\":2,\"name\":\"Rose Inoffensive\",\"description\":\"Petit fleur\",\"family\":\"Fleur\",\"hp\":100,\"energy\":100,\"attack\":20,\"defence\":10,\"imgUrl\":\"https://i.pinimg.com/originals/5c/03/d0/5c03d0df8135b4ea100ba0c4978ebf16.png\",\"price\":200.00,\"iduser\":null},{\"id\":3,\"name\":\"Pume Féroce\",\"description\":\"Gros chaton\",\"family\":\"Felin\",\"hp\":100,\"energy\":100,\"attack\":50,\"defence\":40,\"imgUrl\":\"https://www.chausport.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/9/4/9434-chaussures-puma-suede-classic-junior-noire-vue-exterieure.png\",\"price\":100.00,\"iduser\":null},{\"id\":4,\"name\":\"Lézard or\",\"description\":\"Reptile\",\"family\":\"Lézard\",\"hp\":60,\"energy\":50,\"attack\":20,\"defence\":10,\"imgUrl\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Blazma1.jpg/220px-Blazma1.jpg\",\"price\":50.00,\"iduser\":1}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  

	@Test
	public void addCard() {
		// Lorsque l'on appelera la méthode getCardsUser avec comme paramètre "1", le
		// mock retournera les cartes de l'user 1
		Card cardToAdd = new Card("Pokemon", "chauve souris", "souris", 2, 2, 2, 5, "http://www.batman.png");

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/cards").content(asJsonString(cardToAdd))
				.accept(MediaType.APPLICATION_JSON);
		List<Card> listaddcard = cardService.getAllCards();

		for (Card c : listaddcard) {
			if (c.getName() == "Pokemon") {
				assertEquals(c.getName(), cardToAdd.getName());
			}
		}
	}

}
