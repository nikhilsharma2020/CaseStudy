package com.basha.model.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.basha.bean.Users;
import com.basha.helper.OracleConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public int signUp(Users user) throws ClassNotFoundException, SQLException {
		Connection connection = OracleConnection.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO USERS(NAME,MOBILE_NUMBER,USER_NAME,PASSWORD) VALUES(?,?,?,?)");
		preparedStatement.setString(1, user.getName());
		preparedStatement.setLong(2, user.getMobileNumber());
		preparedStatement.setString(3, user.getUserName());
		preparedStatement.setString(4, user.getPassWord());
		int rows = preparedStatement.executeUpdate();
		return rows;
	}

	@Override
	public Users signIn(Users user) throws ClassNotFoundException, SQLException {
		Users user1 = null;
		Connection connection = OracleConnection.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM USERS WHERE USER_NAME=? AND PASSWORD=? ");

		preparedStatement.setString(1, user.getUserName());
		preparedStatement.setString(2, user.getPassWord());
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String uname = resultSet.getString("USER_NAME");
			String password = resultSet.getString("PASSWORD");
			String name = resultSet.getString("NAME");
			long number=resultSet.getLong("MOBILE_NUMBER");
			user1 = new Users(uname, password, name, number);
//			user1.setUserName(uname);
//			user1.setPassWord(password);
//			user1.setName(name);
		}

		return user1;

	}

}
