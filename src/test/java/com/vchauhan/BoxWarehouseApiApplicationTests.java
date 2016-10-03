package com.vchauhan;

import com.vchauhan.domain.BoxTest;
import com.vchauhan.domain.Role;
import com.vchauhan.domain.User;
import com.vchauhan.domain.UserTest;
import com.vchauhan.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoxWarehouseApiApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserTest userTest;

	@Autowired
	BoxTest boxTest;

	@Test
	public void contextLoads() {
	}

	@Test
	public void insertUser(){
//		User user = new User();
//		user.setUsername("vchauhan");
//		user.setPassword(new BCryptPasswordEncoder().encode("password"));
//		user.setFirstname("Vineet");
//		user.setLastname("Chauhan");
//		user.setEmail("charlie@gmail.com");
//		user.setRole(Role.ROLE_USER);
//		userRepository.save(user);
//
//		User newUser = userRepository.findOne(user.getId());
//		assertNotNull(newUser);
		userTest.insertUser();

	}

	@Test
	public void insertBox(){
		boxTest.insertBox();
	}

}
