package com.basha.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nava.bean.Itoms;
import com.nava.bean.ItomsList;
import com.nava.cartservice.CartService;
import com.nava.cartservice.CartServiceImpl;


public class DeleteProductFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DeleteProductFromCart() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		CartService cartService=new CartServiceImpl();
		Itoms itoms = new Itoms();
		String userName=(String) session.getAttribute("userName");
		String itom=request.getParameter("itom");
		String str=request.getParameter("quantity");
		int quantity=1;
		if(str!="" && str!=null) 
			quantity = Integer.parseInt(str);
		itoms.setUserName(userName);
		itoms.setItoms(itom);
		itoms.setQuantity(quantity);
		System.out.println(quantity);
		try {
			cartService.deleteItomsFromCart(itoms);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		ItomsList cartList=null;
		try {
			cartList=cartService.getItomsFromCart(userName);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		session.setAttribute("cartlist", cartList.getItoms());
		RequestDispatcher dispatcher=request.getRequestDispatcher("./mycart.jsp");
		dispatcher.forward(request, response);
	}
}
	
