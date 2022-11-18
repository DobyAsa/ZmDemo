package com.dobyasa.service.impl;

import com.dobyasa.dao.UserDao;
import com.dobyasa.dao.impl.UserDaoImpl;
import com.dobyasa.entity.Users;
import com.dobyasa.exception.IdIsNullException;
import com.dobyasa.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public boolean addUser(Users users) {
		return userDao.addUser(users);
	}

	@Override
	public int delUserById(Integer id) throws IdIsNullException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delUserByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserById(Integer id) throws IdIsNullException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUser(Users users) {
		return userDao.checkUser(users);
	}

}
