package com.basha.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.basha.bean.Product;
import com.basha.persistance.ProductDao;
import com.basha.persistance.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao=new ProductDaoImpl(); 
	@Override
	public List<Product> listAllProducts() throws ClassNotFoundException, SQLException {
	
		return productDao.listAllProducts();
	}
	@Override
	public Product getProductByCode(String productCode) throws ClassNotFoundException, SQLException {
		
		return productDao.getProductByCode(productCode) ;
	}
	@Override
	public boolean saveProduct(Product product) throws ClassNotFoundException, SQLException {
		int rows=productDao.saveRecord(product);
		if(rows>0)
			return true;
		return false;
	}
	@Override
	public boolean deleteProduct(String productId) throws ClassNotFoundException, SQLException {
		int rows=productDao.deleteRecord(productId);
		if(rows>0)
			return true;
		return false;
	}
}
