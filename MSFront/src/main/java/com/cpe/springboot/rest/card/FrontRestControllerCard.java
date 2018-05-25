package com.cpe.springboot.rest.card;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FrontRestControllerCard {

	RestTemplate restTemplate = new RestTemplate();
	String cardServer = "http://localhost:8081";

	static final String URL_CARDS = "/cards";
	static final String URL_CARDS_USER = "/cardsuser/";
	static final String URL_CARD_SELL = "/sellcard";

	@RequestMapping(path = "/cards", produces = "application/json")
	public String getCardsList() {

		// Data attached to the request.
		String URL = cardServer + URL_CARDS;
		return restTemplate.getForObject(URL, String.class);
	}

	@RequestMapping(path = "/cardsuser/{id}", produces = "application/json")
	public String getCardsUser(@PathVariable Integer id) {

		// Data attached to the request.
		String URL = cardServer + URL_CARDS_USER + id;
		return restTemplate.getForObject(URL, String.class);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/sellcard", consumes = "application/json")
	public void sellcard(@RequestBody String card,@PathVariable String idcard) {
		HttpHeaders headers = new HttpHeaders();

		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		// Data attached to the request.
		HttpEntity<String> requestBody = new HttpEntity<>(card, headers);
		String URL = cardServer + URL_CARD_SELL;
		restTemplate.postForObject(URL, requestBody, String.class);
	}

	// public static void main(String[] args) {
	//
	// // HttpHeaders
	// HttpHeaders headers = new HttpHeaders();
	//
	// headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON
	// }));
	//
	// // HttpEntity<Employee[]>: To get result as String[].
	// HttpEntity<String[]> entity = new HttpEntity<String[]>(headers);
	//
	// // RestTemplate
	// RestTemplate restTemplate = new RestTemplate();
	//
	// // Send request with GET method, and Headers.
	// ResponseEntity<String[]> response = restTemplate.exchange(URL_CARDS_USER +
	// "1", //
	// HttpMethod.GET, entity, String[].class);
	//
	// HttpStatus statusCode = response.getStatusCode();
	// System.out.println("Response Satus Code: " + statusCode);
	//
	// // Status Code: 200
	// if (statusCode == HttpStatus.OK) {
	// // Response Body Data
	// String[] list = response.getBody();
	// if (list != null) {
	// for (String e : list) {
	// System.out.println("String: " + e.getName() + " - " + e.getIduser());
	// }
	// }
	// }
	// }

}