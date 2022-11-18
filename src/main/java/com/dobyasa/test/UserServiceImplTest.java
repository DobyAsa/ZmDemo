package com.dobyasa.test;

import com.dobyasa.entity.Users;
import com.dobyasa.service.UserService;
import com.dobyasa.service.impl.UserServiceImpl;
import org.testng.annotations.Test;

import java.util.Base64;

import static org.testng.AssertJUnit.*;

public class UserServiceImplTest {
	
	private final UserService service = new UserServiceImpl();

	@Test
	public void testAddUser() {
		Users users =new Users();

		users.setName("李逵");
		users.setPwd(Base64.getEncoder().encodeToString("123".getBytes()));

		boolean flag= service.addUser(users);

		// 断言
		assertTrue(flag);
	}

	@Test
	public void testDelUserById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelUserByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUserById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckUser() {

		Users users =new Users();

		users.setName("李逵");
		users.setPwd(Base64.getEncoder().encodeToString("123".getBytes()));

		boolean flag= service.checkUser(users);

		// 断言
		assertTrue(flag);
		
	}

}
