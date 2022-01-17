package com.g2.service;

import java.sql.SQLException;
import java.util.List;

import com.g2.bean.InventoryItem;
import com.g2.persistance.InventoryDao;
import com.g2.persistance.InventoryDaoImpl;

public class InventoryServiceImpl implements InventoryService {
	private InventoryDao inventoryDao = new InventoryDaoImpl();

	public InventoryItem getProductByCode(String productCode) throws ClassNotFoundException, SQLException {

		return inventoryDao.getProductByCode(productCode);
	}

	@Override
	public boolean updateInventoryItemQuantityByProductCode(String productCode, int availableQuantity)
			throws ClassNotFoundException, SQLException {
		int rows = inventoryDao.updateInventoryItemQuantityByProductCode(productCode, availableQuantity);
		if (rows > 0)
			return true;
		return false;
	}

	@Override
	public List<InventoryItem> getAllInventories() throws ClassNotFoundException, SQLException {
		return inventoryDao.getAllInventories();
	}

}
