package com.dobyasa.test;

import com.dobyasa.entity.Users;
import com.dobyasa.service.UserService;
import com.dobyasa.service.impl.UserServiceImpl;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;

public class UserServiceImplTest {
	
	private UserService service = new UserServiceImpl();

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
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
		users.setPwd("123");
		
		boolean flag=service.checkUser(users);
		
		// 断言
		assertEquals(flag, true);
		
	}

}
