package com.g2.persistance;

import java.sql.SQLException;
import java.util.List;

import com.g2.bean.InventoryItem;

public interface InventoryDao {

	InventoryItem getProductByCode(String productCode) throws ClassNotFoundException, SQLException;

	int updateInventoryItemQuantityByProductCode(String productCode, int availableQuantity)
			throws ClassNotFoundException, SQLException;

	List<InventoryItem> getAllInventories() throws ClassNotFoundException, SQLException;

}
