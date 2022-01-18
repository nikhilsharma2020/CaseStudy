package com.basha.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nava.bean.ItomsList;
import com.nava.cartservice.CartService;
import com.nava.cartservice.CartServiceImpl;




public class MyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyCart() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		CartService cartService=new CartServiceImpl();
		String userName=(String) session.getAttribute("userName");
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
