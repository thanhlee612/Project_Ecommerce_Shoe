
package com.laptrinhjava.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjava.dao.ICategoryDAO;
import com.laptrinhjava.model.Category;
import com.laptrinhjava.service.ICategoryService;
import com.laptrinhjava.utils.HttpUtil;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewApi extends HttpServlet {
	@Inject
	private ICategoryService categoryService;
	private static final long serialVersionUID = 1L;

// Them
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Category insert = HttpUtil.offf(req.getReader()).toModel(Category.class);//Client gửi yêu cầu về server (servlet: api-admin-new), Server xử lý chuyển đổi kiểu dữ liệu json sang String, map giá trị vào Category model
	//	Category category = mapper.readValue(req.getInputStream(), Category.class);
		categoryService.save(insert);
		mapper.writeValue(resp.getOutputStream(), insert); //WriteValue object java -> json, getOutputStream() get du lieu trong objectmapper
	}

//sua
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Category capnhat = HttpUtil.offf(req.getReader()).toModel(Category.class);
		categoryService.update(capnhat);//Luu xuong database
		mapper.writeValue(resp.getOutputStream(), capnhat);
	}

//xoa
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/jon");
		Category xoa = HttpUtil.offf(req.getReader()).toModel(Category.class);		
		categoryService.delete(xoa.getIdCates());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

}
