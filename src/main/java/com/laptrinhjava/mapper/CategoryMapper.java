/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhjava.mapper;

import com.laptrinhjava.model.Category;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class CategoryMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs) {
        try {
            Category c = new Category();
            c.setIdCategory(rs.getInt("idCategory"));
            c.setcName(rs.getString("cName"));
            return c;
        } catch (SQLException e) {
            return null;
        }

    }

}
