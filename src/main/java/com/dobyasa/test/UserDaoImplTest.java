package com.dobyasa.test;


import com.dobyasa.dao.UserDao;
import com.dobyasa.dao.impl.UserDaoImpl;
import com.dobyasa.entity.Users;
import org.testng.annotations.Test;

import java.util.Base64;

import static org.testng.AssertJUnit.*;


public class UserDaoImplTest {
	
	private final UserDao userDao = new UserDaoImpl();	// 依赖注入

	@Test
	public void testAddUser() {
		Users users =new Users();

		users.setName("李逵");
		users.setPwd(Base64.getEncoder().encodeToString("123".getBytes()));

		boolean flag=userDao.addUser(users);

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
		
		boolean flag=userDao.checkUser(users);
		
		// 断言
		assertTrue(flag);
		
	}

}
