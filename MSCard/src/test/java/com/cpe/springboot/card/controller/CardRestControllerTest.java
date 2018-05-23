package com.cpe.springboot.card.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

@RunWith(SpringRunner.class)
@WebMvcTest(value = CardRestController.class, secure = false)
public class CardRestControllerTest {
	
	/*@Autowired
	private CardRestController rest;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CardService cardService;

	Card mockCard=new Card("jo", "blue", "super blue", "https:\\\\fakeSite\\data.jpg");
	
	
	@Test
	public void retrieveCard() throws Exception {
		Mockito.when(
				cardService.getCardByColor(Mockito.anyString())).thenReturn(Arrays.asList(mockCard));
				

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cards/color/blue").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{\"id\":null,\"color\":\"blue\",\"superPower\":\"super blue\",\"name\":\"jo\",\"imgUrl\":\"https:\\\\\\\\fakeSite\\\\data.jpg\"}]";


		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}*/
	
	
	//TO BE COMPLETED
	
}
