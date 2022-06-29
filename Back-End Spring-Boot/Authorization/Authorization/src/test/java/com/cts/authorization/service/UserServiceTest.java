package com.cts.authorization.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.authorization.model.User;
import com.cts.authorization.repository.UserRepository;

@SpringBootTest
class UserServiceTest {
	
	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	@Test
	void testFindUserId() {
		User u=new User(1,"Pranjali","1234");	
		Mockito.when(userRepository.findByUsername(u.getUsername())).thenReturn(u);
		assertEquals(1,userService.findUserId(u.getUsername()));
	}

}
