package com.application.serviceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dto.CategoriesDTO;
import com.application.model.Categories;
import com.application.repository.CategoriesRepository;

@Service
public class CategoriesServiceImpl implements CategoriesInterface{
	
	@Autowired
	CategoriesRepository categoriesRopository;

	@Override
	public boolean addCategories(CategoriesDTO dCtegoriesDTO) {

		Categories c = new Categories(dCtegoriesDTO.getName());

		try {
			categoriesRopository.save(c);
			return true;
		} catch (Exception e) {

			System.out.println(e);
		}

		return false;
	}

	@Override
	public boolean deleteCategoriesById(long id) {

		try {
			categoriesRopository.deleteById(id);

			return true;
		} catch (Exception e) {

			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean updateCategories(CategoriesDTO categoriesDTO, long id) {

		// find id object data
		// replace data

		try {
			Categories c = categoriesRopository.findById(id).get();

			c.setName(categoriesDTO.getName());

			categoriesRopository.save(c);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Categories findbyCategoriesId(long id) {

		
		return categoriesRopository.findById(id).get();
	}

}
