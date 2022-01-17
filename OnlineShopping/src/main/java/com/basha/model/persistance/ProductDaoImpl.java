package com.basha.model.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.basha.bean.Product;
import com.basha.bean.Products;
import com.basha.bean.Users;
import com.basha.helper.OracleConnection;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Products listOfProducts() throws ClassNotFoundException, SQLException {

		List<Product> productList = new ArrayList<Product>();
        Products products=new Products();
		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT");
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			int id = resultSet.getInt("ID");
			String code = resultSet.getString("CODE");
			String name = resultSet.getString("NAME");
			String description = resultSet.getString("DESCRIPTION");
			int price = resultSet.getInt("PRICE");

			Product product = new Product(id, code, name, description, price);
			productList.add(product);
		}
		products.setProductList(productList);

		connection.close();

		return products;
	}
	@Override
	public Product selectedProduct(String productCode) throws ClassNotFoundException, SQLException
	{
		//List<Product> productList = new ArrayList<Product>();
		Product product=null;
		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE CODE=?");
		preparedStatement.setString(1, productCode);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			int id = resultSet.getInt("ID");
			String code = resultSet.getString("CODE");
			String name = resultSet.getString("NAME");
			String description = resultSet.getString("DESCRIPTION");
			int price = resultSet.getInt("PRICE");

			 product = new Product(id, code, name, description, price);
			//productList.add(product);
		}

		connection.close();

		return product;
	}

}