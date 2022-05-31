package com.laptrinhjava.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.dao.impl.test;
import com.laptrinhjava.model.Product;
import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.IUserService;
import com.laptrinhjava.utils.FromUtil;
import com.laptrinhjava.utils.Session;

@WebServlet(urlPatterns = { "/test", "/dang-nhap", "/thoat"})
public class test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	IUserService userService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/html;charset=UTF-8");
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		} else if(action != null && action.equals("logout")){
			Session.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath()+"/test");
		}
		else {
			test t = new test();
			List<Product> listTT = t.findAll();
			request.setAttribute("product", listTT);
			request.getRequestDispatcher("/demo.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			
			  UserModel model = new UserModel(); 
			  model = userService.findByUsername(userName, password, 1);
			 
				/*
				 * UserModel model = FromUtil.toModel(UserModel.class, request); model =
				 * userService.findByUsername(model.getUserName(), model.getPassword(), 1);
				 */
			 
			if (model != null) {
				Session.getInstance().putValue(request, "USERMODEL", model);
				if (model.getRole().getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath()+"/test");
				} else if (model.getRole().getCode().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath()+"/admin-home");
				}
			} else {
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
			}
		}
	}

}
