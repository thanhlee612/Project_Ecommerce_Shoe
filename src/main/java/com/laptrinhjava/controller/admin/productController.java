package com.laptrinhjava.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.constant.SystemConstant;
import com.laptrinhjava.model.Category;
import com.laptrinhjava.model.Product;
import com.laptrinhjava.paging.PageRequest;
import com.laptrinhjava.paging.Pageble;
import com.laptrinhjava.service.IProductService;
import com.laptrinhjava.sort.Sorter;
import com.laptrinhjava.utils.FromUtil;


@WebServlet("/admin-product")
public class productController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private IProductService productService;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/html;charset=UTF-8");	
		
		/*
		 * Product product = new Product();
		 * String pageStr = request.getParameter("page"); String maxPageStr =
		 * request.getParameter("maxPageItems"); if(pageStr != null) {
		 * product.setPage(Integer.parseInt(pageStr)); }else { product.setPage(1); }
		 * if(maxPageStr != null) {
		 * product.setMaxPageItems(Integer.parseInt(maxPageStr)); }
		 */
		Product product = FromUtil.toModel(Product.class, request);
		Pageble pageble = new PageRequest(product.getPage(), product.getMaxPageItems(), new Sorter(product.getSortName(), product.getSortBy()));
		product.setListResult(productService.findAll(pageble));
		product.setTotalItem(productService.getTotalItemService());
		product.setTotalPage((int) Math.ceil((double) product.getTotalItem() / product.getMaxPageItems()));
		request.setAttribute(SystemConstant.MODEL, product);
		request.getRequestDispatcher("/views/admin/product/listProduct.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
	
	}

}
