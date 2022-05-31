/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhjava.dao.impl;

import com.laptrinhjava.dao.ICategoryDAO;
import com.laptrinhjava.mapper.CategoryMapper;
import com.laptrinhjava.mapper.ProductMapper;
import com.laptrinhjava.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO {

	@Override
	public Integer saveee(Category c) {
		String sql = "insert into category (cName) values (?)";
		return insert(sql, c.getcName());
	}

	@Override
	public void updateee(Category category) {
		String sql = "update category set cName = ? where idcategory = ?";
		updateordelete(sql, category.getcName(), category.getIdCategory());
//	StringBuilder sql1 = new StringBuilder("Update category set");
//	sql1.append(" cName= ?,");
//	sql1.append(" where idcategory = ?");

	}


	@Override
	public Category findOne(Integer id) {
		String sql = "select * from Category where idCategory = ?";
		List<Category> cate = query(sql, new CategoryMapper(), id);
		return cate.isEmpty() ? null : cate.get(0);
	}

	@Override
	public List<Category> findAll() {
		String sql = "select *from Category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public void deleteee(Integer id) {
		String sql = "delete from category where idCategory = ?";
		updateordelete(sql, id);//AbstractDAO
	}

}
