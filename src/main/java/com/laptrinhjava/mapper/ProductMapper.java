package com.laptrinhjava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjava.model.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs) {	
		try {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setPname(rs.getString("pname"));
			p.setImage(rs.getString("image"));
			p.setPrice(rs.getFloat("price"));
			p.setTitle(rs.getString("title"));
			p.setPdescription(rs.getString("pdescription"));
			p.setCateID(rs.getInt("cateID"));
			return p;
		} catch (SQLException e) {		
			return null;
		}
		
	}

}
