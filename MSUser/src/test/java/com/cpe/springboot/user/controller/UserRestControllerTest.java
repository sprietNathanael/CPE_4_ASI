package com.cpe.springboot.user.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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

import com.cpe.springboot.user.model.User;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserRestController.class, secure = false)
public class UserRestControllerTest {

	@Autowired
	private UserRestController rest;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	String surname = "Flo";
	String password = "azerty";
	User mockUser;
	List<User> listUser = new ArrayList<User>();
	int idUser = 1;

	@Before
	public void setUp() throws Exception {
		mockUser = new User("Floriane", password, surname);
		mockUser.setId(idUser);
		listUser.add(mockUser);
		User u = new User("Thomas", password, "Thomas");
		u.setId(2);
		listUser.add(u);

	}

	@Test
	public void getUser() throws Exception {
		// Lorsque l'on appelera la méthode getUser avec comme paramètre "1", le mock
		// retournera user
		Mockito.when(userService.getUser(String.valueOf(idUser))).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/" + mockUser.getId())
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("Result: " + result.getResponse().getContentAsString());
		String expected = "{\"id\":1,\"name\":\"Floriane\",\"password\":\"azerty\",\"surname\":\"Flo\",\"cash\":5000.00,\"token\":null}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void getAllUsers() throws Exception {

		// Lorsque l'on appelera la méthode getAllUsers avec comme paramètre "1", le
		// mock
		// retournera user
		Mockito.when(userService.getAllUsers()).thenReturn(listUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("Result: " + result.getResponse().getContentAsString());
		String expected = "[{\"id\":1,\"name\":\"Floriane\",\"password\":\"azerty\",\"surname\":\"Flo\",\"cash\":5000.00,\"token\":null},{\"id\":2,\"name\":\"Thomas\",\"password\":\"azerty\",\"surname\":\"Thomas\",\"cash\":5000.00,\"token\":null}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void login() {

		// Lorsque l'on appelera la méthode findOneBySurnameAndPassword avec comme
		// paramètre surname et
		// password, le mock
		// retournera user
		Mockito.when(userService.findOneBySurnameAndPassword(surname, password)).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/users/login?surname=" + surname + "&password=" + password).accept(MediaType.APPLICATION_JSON);

		MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			System.out.println("Result: " + result.getResponse().getContentAsString());
			assertTrue(result != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
