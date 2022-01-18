package com.basha.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basha.bean.Users;
import com.basha.model.service.UserService;
import com.basha.model.service.UserServiceImpl;
import com.nava.cartservice.CartServiceImpl;

/**
 * Servlet implementation class SignUpController
 */
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String name = request.getParameter("name");
		long number = Long.parseLong(request.getParameter("number"));
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");

		Users user= new Users(username, password, name, number);
		UserService userService = new UserServiceImpl();

		String message = null;

		try {
			if (userService.signUp(user)) {
				CartServiceImpl cartService=new CartServiceImpl();
				cartService.createNewCart(username);
				message = "User Registerd successfully";
				session.setAttribute("message", message);
				RequestDispatcher dispatcher = request.getRequestDispatcher("./secondmenu.jsp");
				dispatcher.forward(request, response);

			} else {
				message = "User Not Registerd Try Again!";
				session.setAttribute("message", message);
				RequestDispatcher dispatcher = request.getRequestDispatcher("./output2.jsp");
				dispatcher.forward(request, response);

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
