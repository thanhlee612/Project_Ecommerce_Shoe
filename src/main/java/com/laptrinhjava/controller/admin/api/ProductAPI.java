package com.laptrinhjava.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjava.model.Product;
import com.laptrinhjava.service.IProductService;
import com.laptrinhjava.utils.HttpUtil;


@WebServlet("/api-admin-product")
public class ProductAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Inject
     private IProductService ProductDAO;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Product p = HttpUtil.offf(request.getReader()).toModel(Product.class);
		ProductDAO.saveIProductService(p);
		mapper.writeValue(response.getOutputStream(), p);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
