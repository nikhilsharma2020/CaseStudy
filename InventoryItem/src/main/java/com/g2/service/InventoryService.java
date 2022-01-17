package com.g2.service;

import java.sql.SQLException;
import java.util.List;

import com.g2.bean.InventoryItem;

public interface InventoryService {

	InventoryItem getProductByCode(String productCode) throws ClassNotFoundException, SQLException;

	boolean updateInventoryItemQuantityByProductCode(String productCode, int availableQuantity)
			throws ClassNotFoundException, SQLException;

	List<InventoryItem> getAllInventories() throws ClassNotFoundException, SQLException;
}
