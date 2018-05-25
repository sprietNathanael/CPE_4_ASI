package com.cpe.springboot.user.controller;

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

import com.cpe.springboot.user.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserServiceTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void saveUser() {
		String name = "joe";
		String surname = "jo";
		String password = "azerty";
		userRepository.save(new User(name, password, surname));
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		assertTrue(users.get(users.size() - 1).getName().equals(name));
		assertTrue(users.get(users.size() - 1).getSurname().equals(surname));
		assertTrue(users.get(users.size() - 1).getPassword().equals(password));
	}

	@Test
	public void findAllUser() {

		String name = "joe";
		String surname = "jo";
		String password = "azerty";

		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		int sizebeforeinsert = users.size();

		for (int i = 0; i < 10; i++) {
			userRepository.save(new User(name + i, password + i, surname + i));
		}

		users.clear();
		userRepository.findAll().forEach(users::add);
		int sizeafterinsert = 10 + sizebeforeinsert;
		assertTrue(users.size() == (sizeafterinsert));

		for (int i = sizebeforeinsert; i < 10; i++) {
			String nameUser = users.get(i).getName();
			nameUser.split(name);
			int index = Integer.valueOf(nameUser.split(name)[1]);
			assertTrue(users.get(i).getName().equals(name + index));
			assertTrue(users.get(i).getPassword().equals(password + index));
			assertTrue(users.get(i).getSurname().equals(surname + index));
		}
	}

	@Test
	public void findOneBySurnameAndPassword() {

		String name = "Floriane";
		String surname = "Flo";
		String password = "azerty";

		User user = userRepository.findOneBySurnameAndPassword(surname, password);
		assertTrue(user != null);

		assertTrue(user.getName().equals(name));
		assertTrue(user.getSurname().equals(surname));
		assertTrue(user.getPassword().equals(password));
	}

	@Test
	public void findOne() {

		int id = 1;
		String name = "Floriane";
		String surname = "Flo";
		String password = "azerty";
		User user = userRepository.findOne(id);
		assertTrue(user != null);
		assertTrue(user.getId().equals(id));
		assertTrue(user.getName().equals(name));
		assertTrue(user.getSurname().equals(surname));
		assertTrue(user.getPassword().equals(password));
	}

	@Test
	public void delete() {

		int id = 1;

		User user = userRepository.findOne(id);
		assertTrue(user != null);
		userRepository.delete(id);

		user = userRepository.findOne(id);
		assertTrue(user == null);
	}
}
