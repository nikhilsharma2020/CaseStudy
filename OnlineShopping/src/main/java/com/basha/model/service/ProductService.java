package com.basha.model.service;

import java.sql.SQLException;
import java.util.List;

import com.basha.bean.BillGeneration;
import com.basha.bean.Product;
import com.basha.bean.Products;

public interface ProductService {


	Products listOfProducts()throws ClassNotFoundException,SQLException;
	Product selectedProduct(String name) throws ClassNotFoundException, SQLException;
    BillGeneration generateBill(String productCode) throws ClassNotFoundException, SQLException;
}