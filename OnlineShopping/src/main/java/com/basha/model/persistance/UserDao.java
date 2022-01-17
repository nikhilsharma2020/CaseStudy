package com.basha.model.persistance;

import java.sql.SQLException;

import com.basha.bean.Users;

public interface UserDao {
	public int signUp(Users user) throws ClassNotFoundException, SQLException;

	Users signIn(Users users) throws ClassNotFoundException, SQLException;
}
