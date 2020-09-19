package com.ssafy.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.product.util.DBUtil;
import com.ssafy.product.vo.Product;


public class ProductDAOImpl implements ProductDAO{

	private final String insertSQL = "INSERT INTO product (name, price, description) VALUES (?, ?, ?)";

	@Override
	public void addProduct(Product p) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getPrice());
			pstmt.setString(3, p.getDesc());

			pstmt.executeUpdate();
			System.out.println("추가 완료!");

		}catch(SQLException e) {
			System.out.println("입력 오류 : " + e);
		}finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	private final String selectSQL = "SELECT * FROM product";

	@Override
	public List<Product> showProduct() {
		List<Product> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(selectSQL);
			rst = stmt.executeQuery();

			while(rst.next()) {
				Product p = new Product();

				p.setId(Integer.parseInt(rst.getString(1)));
				p.setName(rst.getString(2));
				p.setPrice(Integer.parseInt(rst.getString(3)));
				p.setDesc(rst.getString(4));

				list.add(p);
			}

		}catch(SQLException e) {
			System.out.println("조회 오류 : " + e);
		}finally {
			DBUtil.close(rst);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}

		return list;
	}

}
