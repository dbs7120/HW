package com.ssafy.product.dao;

import java.util.List;

import com.ssafy.product.model.Product;
import com.ssafy.product.model.Search;

public interface ProductDao {
	public void addProduct(Product productDto);

	public List<Product> allProduct(Search searchDto);

	public void deleteProduct(int product_id);
}
