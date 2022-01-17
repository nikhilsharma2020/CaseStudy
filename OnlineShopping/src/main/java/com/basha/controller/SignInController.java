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

public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");

		UserService userService = new UserServiceImpl();
		Users user = new Users();
		user.setUserName(username);
		user.setPassWord(password);
		Users user1 = null;
		try {
			user1 = userService.signIn(user);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		session.setAttribute("user1", user1);
		String message = null;
		if (user1 == null) {
			message = "Please Enter Valid User Name or Password!";
			session.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./output.jsp");
			dispatcher.forward(request, response);
		} else if (username.equals(user1.getUserName()) && password.equals(user1.getPassWord())) {
			response.sendRedirect("./homemenu.jsp");

		}

	}

	}

