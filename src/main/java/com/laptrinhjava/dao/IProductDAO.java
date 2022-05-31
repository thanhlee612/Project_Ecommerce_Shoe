package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.model.Product;
import com.laptrinhjava.paging.Pageble;

public interface IProductDAO extends GenericDAO<Product> {
	List<Product> findAll(Pageble pageble);

	List<Product> find4Product();

	List<Product> findNext4Product(int amount);

	Product DetailProduct(int id);

	List<Product> searchByname(String txt);

	Integer saveIProductDAO(Product product);

	void updateIProductDAO(Product product);

	void deleteIProductDAO(Integer id);
	
	int getTotalItemDAO();
}
