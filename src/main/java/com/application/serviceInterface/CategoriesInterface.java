package com.application.serviceInterface;

import com.application.dto.CategoriesDTO;
import com.application.model.Categories;

public interface CategoriesInterface {
	
	public  boolean  addCategories(CategoriesDTO dCtegoriesDTO);

	public boolean deleteCategoriesById(long id);

	public boolean updateCategories(CategoriesDTO categoriesDTO, long id);

	public Categories findbyCategoriesId(long id);
}
