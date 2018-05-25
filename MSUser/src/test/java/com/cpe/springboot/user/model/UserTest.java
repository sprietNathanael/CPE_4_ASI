package com.cpe.springboot.user.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpe.springboot.user.controller.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void createUser() {
		String surname = "jo";
		String mdp = "azerty";
		userRepository.save(new User("joe", mdp, surname));
		User user = userRepository.findOneBySurnameAndPassword(surname, mdp);
		assertNotNull(user);
		assertEquals(user.getSurname(), surname);
		assertEquals(user.getPassword(), mdp);
	}
}
