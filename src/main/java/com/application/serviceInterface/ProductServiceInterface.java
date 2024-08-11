package com.application.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.application.dto.ProductDTO;
import com.application.model.Product;

public interface ProductServiceInterface {

	public boolean addProductDetails(ProductDTO productDTO);

	public List<Product> viewProductList();

	public Optional<Product> findByProductId(long id);

	public boolean deleteByProductId(long id);
}
