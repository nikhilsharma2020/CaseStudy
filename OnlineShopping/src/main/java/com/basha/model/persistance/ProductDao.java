package com.basha.model.persistance;

import java.sql.SQLException;
import java.util.List;
import com.basha.bean.Product;
import com.basha.bean.Products;
import com.basha.bean.Users;

public interface ProductDao {
	Products listOfProducts() throws ClassNotFoundException, SQLException;
	public Product selectedProduct(String productName) throws ClassNotFoundException, SQLException;
}