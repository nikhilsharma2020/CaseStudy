package com.nava.cartpersistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.basha.helper.OracleConnection;


public class CartDaoImpl implements CartDao {
	
	@Override
	public String createNewCart(String userName) {
		String s="can't create";
		Connection connection;
		try {
			connection = OracleConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CART VALUES (?,'')");
			preparedStatement.setString(1, userName);
			int row=preparedStatement.executeUpdate();
			if(row!=0)
				s="new Cart Created";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	@Override
	public Boolean updateItomInCart(String userName,String itoms) {
		Connection connection;
		try {
			connection = OracleConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE CART SET ITOMS=? WHERE USERNAME=?");
			preparedStatement.setString(1, itoms);
			preparedStatement.setString(2,userName );
			int row=preparedStatement.executeUpdate();
			connection.close();
			if(row!=0)
				return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getItomsFromCart(String userName) {
		String itoms="";
		try {
			Connection connection = OracleConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CART WHERE USERNAME=?");
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				itoms= resultSet.getString("ITOMS");
			}
			else {
				itoms="cart empty";
			}
			connection.close();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itoms;
	}



}
