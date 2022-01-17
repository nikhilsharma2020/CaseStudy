package com.basha.model.service;


import java.sql.SQLException;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.basha.bean.BillGeneration;
import com.basha.bean.Product;
import com.basha.bean.Products;

import com.basha.model.persistance.ProductDao;
import com.basha.model.persistance.ProductDaoImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ProductServiceImplementation implements ProductService {

	private ProductDao productDao = new ProductDaoImpl();

	@Override
	public Products  listOfProducts() throws ClassNotFoundException, SQLException {

		Products products=null;
		Client client=ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
		WebTarget webTarget=client.target("http://localhost:8085/Product/webapi/").path("products");
	    Invocation.Builder builder=webTarget.request(MediaType.APPLICATION_JSON);
		Response response=builder.get();
		products=response.readEntity(Products.class);
		
//		List<Product> list=new Gson().fromJson(response, new TypeToken<ArrayList<Product>>() {}.getType());
//		return list;
		return products;
	  
	}
	@Override
	public Product selectedProduct(String code)throws ClassNotFoundException, SQLException{
		return productDao.selectedProduct(code);
	}
	@Override
    public BillGeneration generateBill(String productCode) throws ClassNotFoundException, SQLException {
		
		   Product product=productDao.selectedProduct(productCode);
		
		BillGeneration billGeneration=null;
		if(product!=null) {
			double gst=product.getPrice()*.18;
			double shippingCharge=product.getPrice()+40;
			double totalBill=product.getPrice()+shippingCharge+gst;
			billGeneration =new BillGeneration(product, gst, shippingCharge, totalBill);
		}
		return billGeneration;
}
}