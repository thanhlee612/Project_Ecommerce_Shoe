package com.laptrinhjava.dao.impl;

import java.util.List;

import com.laptrinhjava.dao.IProductDAO;
import com.laptrinhjava.mapper.ProductMapper;
import com.laptrinhjava.model.Product;
import com.laptrinhjava.paging.Pageble;

public class ProductDAO extends AbstractDAO<Product> implements IProductDAO {

    @Override
    public List<Product> findAll(Pageble pageble) {
    	StringBuilder sql = new StringBuilder("select *from Product ");
    	if(pageble.getSorter() != null){
    		sql.append("order by "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+" ");
    	}
    	if(pageble.getOffset() != null && pageble.getLimit() != null) {
    		sql.append("limit "+pageble.getOffset()+", "+pageble.getLimit()+" ");
    	}
    	return query(sql.toString(), new ProductMapper());
        
    }

    @Override
    public List<Product> find4Product() {
        String sql = "select * from Product Limit 4";
        return query(sql, new ProductMapper());
    }

    @Override
    public List<Product> findNext4Product(int amount) {
        String sql = " SELECT * FROM Product ORDER BY id LIMIT ?, 4;";
        return query(sql, new ProductMapper(), amount);
    }

    @Override
    public Product DetailProduct(int id) {
        String sql = "Select * from Product where id=?";
        List<Product> product = query(sql, new ProductMapper(), id);
        return product.isEmpty() ? null : product.get(0);
    }

    @Override
    public List<Product> searchByname(String txt) {
        String sql = "select * from Product where pname like '%?%'";
          return query(sql, new ProductMapper(), txt);
    }

	@Override
	public Integer saveIProductDAO(Product p) {
		StringBuilder sql = new StringBuilder("insert into product(id, pname, image, price, title, pdescription, cateid) values ");
		sql.append("("+p.getId()+", "+p.getPname()+", "+p.getImage()+", "+p.getPrice()+", "+p.getTitle()+", "+p.getPdescription()+", "+p.getCateID()+")");
		return insert(sql.toString());
		//, p.getId(), p.getPname(), p.getImage(), p.getPrice(), p.getTitle(), p.getPdescription(), p.getCateID()
	}



	@Override
	public void updateIProductDAO(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteIProductDAO(Integer id) {
		  String sql = "Delete * from Product where id=?";
		 updateordelete(sql, id);	
	}

	@Override
	public int getTotalItemDAO() {
		String sql = "select count(*) from product";
		return count(sql);
	}

  
  
    
}
