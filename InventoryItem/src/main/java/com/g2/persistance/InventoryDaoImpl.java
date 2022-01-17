package com.g2.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.OverridesAttribute;

import com.g2.bean.InventoryItem;
import com.g2.helper.OracleConnection;

public class InventoryDaoImpl implements InventoryDao {

	@Override
	public InventoryItem getProductByCode(String productCode) throws ClassNotFoundException, SQLException {

		InventoryItem inventoryItem = null;

		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM INVENTORY WHERE CODE=?");
		preparedStatement.setString(1, productCode);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code = resultSet.getString("CODE");
			int quantity = resultSet.getInt("QUANTITY");

			inventoryItem = new InventoryItem(id, code, quantity);

		}

		connection.close();
		return inventoryItem;
	}

	@Override
	public int updateInventoryItemQuantityByProductCode(String productCode, int availableQuantity)
			throws ClassNotFoundException, SQLException {

		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE INVENTORY SET QUANTITY=? WHERE CODE=?");
		preparedStatement.setInt(1, availableQuantity);
		preparedStatement.setString(2, productCode);

		int rows = preparedStatement.executeUpdate();
		connection.close();
		return rows;
	}

	@Override
	public List<InventoryItem> getAllInventories() throws ClassNotFoundException, SQLException {

		List<InventoryItem> inventoryList = new ArrayList<InventoryItem>();
		InventoryItem inventoryItem = null;

		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM INVENTORY");
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code = resultSet.getString("CODE");
			int quantity = resultSet.getInt("QUANTITY");

			inventoryItem = new InventoryItem(id, code, quantity);
			inventoryList.add(inventoryItem);
		}

		connection.close();

		return inventoryList;
	}
}
