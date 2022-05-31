package com.laptrinhjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjava.model.Product;

public class test {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<Product> findAll() {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * FROM Product LIMIT 4";
		conn = DBContext.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setPname(rs.getString("pname"));
				p.setImage(rs.getString("image"));
				p.setPrice(rs.getFloat("price"));
				p.setTitle(rs.getString("title"));
				p.setPdescription(rs.getString("pdescription"));
				p.setCateID(rs.getInt("cateID"));
				list.add(p);
			}
		} catch (SQLException e) {
			return null;
		}		
		return list;
	}
	
	
	public List<Product> findNext4product(int amount) {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * FROM Product ORDER BY id LIMIT ?, 4";
		conn = DBContext.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, amount);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setPname(rs.getString("pname"));
				p.setImage(rs.getString("image"));
				p.setPrice(rs.getFloat("price"));
				p.setTitle(rs.getString("title"));
				p.setPdescription(rs.getString("pdescription"));
				p.setCateID(rs.getInt("cateID"));
				list.add(p);
			}
		} catch (SQLException e) {
			return null;
		}
		return list;
	}
        
        
        public List<Product> searchByName(String tname) {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * FROM Product where pname like ?";
		conn = DBContext.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" +tname+ "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setPname(rs.getString("pname"));
				p.setImage(rs.getString("image"));
				p.setPrice(rs.getFloat("price"));
				p.setTitle(rs.getString("title"));
				p.setPdescription(rs.getString("pdescription"));
				p.setCateID(rs.getInt("cateID"));
				list.add(p);
			}
		} catch (SQLException e) {
			return null;
		}
		return list;
	}
}
