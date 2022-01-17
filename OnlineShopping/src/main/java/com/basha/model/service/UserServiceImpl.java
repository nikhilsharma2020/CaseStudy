package com.basha.model.service;

import java.sql.SQLException;

import com.basha.bean.Users;
import com.basha.model.persistance.ProductDao;
import com.basha.model.persistance.ProductDaoImpl;
import com.basha.model.persistance.UserDao;
import com.basha.model.persistance.UserDaoImpl;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public boolean signUp(Users user) throws ClassNotFoundException, SQLException {
		int rows = userDao.signUp(user);
		if (rows > 0)
			return true;
		return false;
	}

	@Override
	public Users signIn(Users user) throws ClassNotFoundException, SQLException {
		Users user1 = userDao.signIn(user);

		return user1;
	}

}
