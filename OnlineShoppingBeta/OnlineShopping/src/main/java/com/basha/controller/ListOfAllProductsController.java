package com.basha.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basha.bean.Products;
import com.basha.model.service.ProductService;
import com.basha.model.service.ProductServiceImplementation;


public class ListOfAllProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		ProductService productService=new ProductServiceImplementation();
		Products productList=null;
			try {
				productList=productService.listOfProducts();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		session.setAttribute("productlist", productList.getProductList());
		RequestDispatcher dispatcher=request.getRequestDispatcher("./listofproducts.jsp");
		dispatcher.forward(request, response);
	
	}

}
