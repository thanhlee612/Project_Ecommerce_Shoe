package com.laptrinhjava.service.impl;

import com.laptrinhjava.dao.ICategoryDAO;
import com.laptrinhjava.mapper.RowMapper;
import com.laptrinhjava.model.Category;
import com.laptrinhjava.service.ICategoryService;
import java.util.List;
import javax.inject.Inject;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO categoryId;

	@Override
	public Category save(Category category) {
		Integer id = categoryId.saveee(category);
		return categoryId.findOne(id);
		// categoryId.saveee(category);
		// return categoryId.findOne(category.getIdCategory());
	}

	@Override
	public Category update(Category updateNew) {
//		Category oldCate = categoryId.findOne(updateNew.getIdCategory());
//		updateNew.setcName(oldCate.getcName());
		categoryId.updateee(updateNew);
		return categoryId.findOne(updateNew.getIdCategory());
	}

	@Override
	public void delete(Integer[] ids) {
		for (int id : ids) {
			categoryId.deleteee(id);//'deleteee' of ICategoryDAO
		}

	}



}
