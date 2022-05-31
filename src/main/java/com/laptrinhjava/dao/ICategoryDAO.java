/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.model.Category;
import com.laptrinhjava.model.Product;

/**
 *
 * @author ASUS
 */
public interface ICategoryDAO extends GenericDAO<Category> {
	List<Category> findAll();
	
	Category findOne(Integer id);

	Integer saveee(Category category);

	void updateee(Category category);

	void deleteee(Integer id);
}
