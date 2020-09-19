package com.ssafy.product.dao;

import java.util.List;

import com.ssafy.product.vo.Product;


public interface ProductDAO {
	void addProduct(Product p);
	List<Product> showProduct();
}
