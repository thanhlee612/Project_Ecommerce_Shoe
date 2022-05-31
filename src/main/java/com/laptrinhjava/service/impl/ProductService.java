package com.laptrinhjava.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjava.dao.IProductDAO;

import com.laptrinhjava.model.Product;
import com.laptrinhjava.paging.Pageble;
import com.laptrinhjava.service.IProductService;

public class ProductService implements IProductService {

    @Inject
    private IProductDAO productDAO;
     
    // select tat ca san pham

    @Override
    public List<Product> findAll(Pageble pageble) {
        return productDAO.findAll(pageble);
    }

    //Select 4 san pham
    @Override
    public List<Product> find4Product() {
        return productDAO.find4Product();
    }

    //Select 4 san pham tiep theo 
    @Override
    public List<Product> findNext4Product(int amount) {
        return productDAO.findNext4Product(amount);
    }

    //Select chi tiet 1 san pham
    @Override
    public Product DetailProduct(int id) {
        return productDAO.DetailProduct(id);
    }

    @Override
    public List<Product> searchByname(String txt) {
        return productDAO.searchByname(txt);
    }


	@Override
	public Product saveIProductService(Product p) {
		Integer id = productDAO.saveIProductDAO(p);
		return productDAO.DetailProduct(id);
	}

	@Override
	public int getTotalItemService() {
		return productDAO.getTotalItemDAO();
	}

	@Override
	public void delete(int[] ids) {
		for(int id : ids) {
			 productDAO.deleteIProductDAO(id);
		}
		
	}

   

}
