package com.laptrinhjava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjava.model.roleModel;
import com.laptrinhjava.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel p = new UserModel();
			p.setId(rs.getInt("id"));
			p.setUserName(rs.getString("username"));
			p.setPassword(rs.getString("password"));
			p.setFullName(rs.getString("fullname"));
			p.setStatus(rs.getInt("status"));
			try{
				roleModel role = new roleModel();
				role.setId(rs.getInt("id"));
				role.setCode(rs.getString("code"));
				role.setName(rs.getString("name"));
				p.setRole(role);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			return p;
		} catch (SQLException e) {		
			return null;
		}
	}

}
