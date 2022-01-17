package com.basha.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.basha.bean.Product;

public interface ProductService {
	
	public List<Product> listAllProducts() throws ClassNotFoundException,SQLException;
	public Product getProductByCode(String productCode)throws ClassNotFoundException,SQLException;
	public boolean saveProduct(Product product) throws ClassNotFoundException, SQLException;
	public boolean deleteProduct(String productId) throws ClassNotFoundException, SQLException;
}
