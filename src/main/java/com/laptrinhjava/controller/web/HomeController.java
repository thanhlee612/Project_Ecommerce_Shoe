package com.laptrinhjava.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.ICategoryService;
import com.laptrinhjava.service.IProductService;
import com.laptrinhjava.utils.FromUtil;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject
	private IProductService productService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/html;charset=UTF-8");	
		String action = request.getParameter("action");
		if(action != null & action.equals("login")) {
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}else if(action != null & action.equals("logout")) {
			
		}else {
			request.setAttribute("product", productService.find4Product());
			request.getRequestDispatcher("/views/web/home.jsp").forward(request, response);
		}		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null & action.equals("login")) {
			UserModel model = FromUtil.toModel(UserModel.class, request);
		}
	}

}
