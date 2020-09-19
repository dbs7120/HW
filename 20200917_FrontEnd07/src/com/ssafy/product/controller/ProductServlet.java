package com.ssafy.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.product.dao.ProductDAO;
import com.ssafy.product.dao.ProductDAOImpl;
import com.ssafy.product.vo.Product;

@WebServlet("/addProduct.do")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");

		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setDesc(desc);

		ProductDAO dao = new ProductDAOImpl();
		dao.addProduct(product);
		System.out.println(product.toString());

		response.sendRedirect("index.html");
	}

}
