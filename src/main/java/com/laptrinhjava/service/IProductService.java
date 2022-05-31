package com.laptrinhjava.service;

import java.util.List;

import com.laptrinhjava.model.Product;
import com.laptrinhjava.paging.Pageble;

public interface IProductService{
	List<Product> findAll(Pageble pageble);
	List<Product> find4Product();
	List<Product> findNext4Product(int amount);
	Product DetailProduct(int id);
    List<Product> searchByname(String txt);
     
    void delete(int[] ids);
    Product saveIProductService(Product p);
    
    int getTotalItemService();
    
}
