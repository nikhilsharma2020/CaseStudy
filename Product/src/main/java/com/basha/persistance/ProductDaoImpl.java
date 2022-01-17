package com.basha.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.basha.bean.Product;
import com.basha.helper.OracleConnection;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> listAllProducts() throws ClassNotFoundException, SQLException {
		
        List<Product> productList = new ArrayList<Product>();
		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code = resultSet.getString("CODE");
			String name = resultSet.getString("NAME");
			String description = resultSet.getString("DESCRIPTION");
			double price = resultSet.getDouble("PRICE");
			
			Product product=new Product(id, code, name, description, price);
			productList.add(product);
		}

		connection.close();

		return productList;
	}

	@Override
	public Product getProductByCode(String productCode) throws ClassNotFoundException, SQLException {

		Product product=null;
		
		Connection connection = OracleConnection.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS WHERE CODE=?");
		preparedStatement.setString(1, productCode);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code = resultSet.getString("CODE");
			String name = resultSet.getString("NAME");
			String description = resultSet.getString("DESCRIPTION");
			double price = resultSet.getDouble("PRICE");
			
			 product=new Product(id, code, name, description, price);
		
		}

		connection.close();
		return product;
	}
    @Override
	public int saveRecord(Product product) throws ClassNotFoundException, SQLException {

		Connection connection = OracleConnection.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO PRODUCTS(ID,CODE,NAME,DESCRIPTION,PRICE) VALUES(?,?,?,?,?)");
		
		
		preparedStatement.setLong(1,product.getId() );
		preparedStatement.setString(2, product.getCode());
		preparedStatement.setString(3, product.getName());
		preparedStatement.setString(4, product.getDescription());
		preparedStatement.setDouble(5, product.getPrice());
		
		
		int rows=preparedStatement.executeUpdate();

		return rows;
	}
	
    @Override
    public int deleteRecord(String productId) throws ClassNotFoundException, SQLException {
		Connection connection = OracleConnection.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM PRODUCTS WHERE ID=?");
		
		preparedStatement.setString(1, productId);
		
		int rows=preparedStatement.executeUpdate();

		return rows;
	}
    public int updateProduct(double price,String productId)throws ClassNotFoundException, SQLException{
    	Connection connection = OracleConnection.getConnection();
    	PreparedStatement preparedStatement=connection.prepareStatement("UPDATE PRODUCTS SET PRICE=? WHERE ID=?");
    	preparedStatement.setDouble(1, price);
    	preparedStatement.setString(2, productId);
    	int rows=preparedStatement.executeUpdate();
    	return rows;
    }

}
