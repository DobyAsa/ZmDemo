package com.dobyasa.test;


import com.dobyasa.dao.UserDao;
import com.dobyasa.dao.impl.UserDaoImpl;
import com.dobyasa.entity.Users;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;


public class UserDaoImplTest {
	
	private UserDao userDao = new UserDaoImpl();	// 依赖注入

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
		
		boolean flag=userDao.checkUser(users);
		
		// 断言
		assertEquals(flag, true);
		
	}

}
