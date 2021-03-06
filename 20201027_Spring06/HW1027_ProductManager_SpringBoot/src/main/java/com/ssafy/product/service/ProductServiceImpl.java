package com.ssafy.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.dao.ProductDao;
import com.ssafy.product.model.Product;
import com.ssafy.product.model.Search;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addProduct(Product productDto) {
		sqlSession.getMapper(ProductDao.class).addProduct(productDto);

	}

	@Override
	public List<Product> allProduct(Search searchDto) {
		return sqlSession.getMapper(ProductDao.class).allProduct(searchDto);
		
	}

	@Override
	public void deleteProduct(int product_id) {
		sqlSession.getMapper(ProductDao.class).deleteProduct(product_id);

	}

}
