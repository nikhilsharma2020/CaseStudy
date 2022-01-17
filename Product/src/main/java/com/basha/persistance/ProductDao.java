package com.basha.persistance;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.basha.bean.Product;

public interface ProductDao {

	public List<Product> listAllProducts() throws ClassNotFoundException,SQLException;
	public Product getProductByCode(String productCode) throws ClassNotFoundException, SQLException;
	public int saveRecord(Product product) throws ClassNotFoundException, SQLException;
    public int deleteRecord(String productId) throws ClassNotFoundException, SQLException;
}
