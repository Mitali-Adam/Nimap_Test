package com.application.serviceInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dto.ProductDTO;
import com.application.model.Categories;
import com.application.model.Product;
import com.application.repository.CategoriesRepository;
import com.application.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductServiceInterface {

	@Autowired
	private ProductRepository prodcutRepository;
	
	@Autowired
	CategoriesRepository  categoriesRopository; 
	
	

	@Override
	public boolean addProductDetails(ProductDTO productDTO) {

		try {
			
			
			Categories category =  categoriesRopository.findById(productDTO.getCategoriesId()).get();
			
			Product p = new Product(productDTO.getProductName(), productDTO.getManufacturingDate(), productDTO.getPrice(), productDTO.getExpDate(),category);
			
			prodcutRepository.save(p);
			return true;
		} catch (Exception ex) {
			System.out.println("Repository Exception is " + ex);
			return false;
		}

	}

	@Override
	public List<Product> viewProductList() {
		return prodcutRepository.findAll();
	}

	@Override
	public Optional<Product> findByProductId(long id) {

		Optional<Product> product = prodcutRepository.findById(id);
		return product;
	}

	@Override
	public boolean deleteByProductId(long id) {

		try {
			prodcutRepository.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}


}
