<%@page import="com.ssafy.product.vo.Product"%>
<%@page import="com.ssafy.product.dao.ProductDAOImpl"%>
<%@page import="com.ssafy.product.dao.ProductDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	ProductDAO dao = new ProductDAOImpl();
List<Product> list = dao.showProduct();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<script>
	function back(event) {
		event.preventDefault();
		location.href = "index.html";
	}
</script>
</head>
<body>
	<table border="1" width="500px">
		<caption style="font-size: 50px">상품 리스트</caption>
		<thead>
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>상품설명</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Product p : list) {
			%>
			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getName()%></td>
				<td><%=p.getPrice()%>
				</td>
				<td><%=p.getDesc()%></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
	<div>
		<button onclick="back(event)">뒤로가기</button>
	</div>
</body>
</html>