<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>Welcome To SSAFY</h1>
	<hr>

	<h2>상품 관리</h2>
	<div>
		<button id="listBtn">목록조회</button>
		(상세 내용을 조회하기 위해서 목록의 아이템을 클릭하세요)
	</div>
	<ul id="productList"></ul>
	<div>
		<button id="addBtn">추가</button>
		<button id="delBtn">삭제</button>
	</div>
	<form id="inputForm">
		<div>
			<span>ID</span> <input type="text" id="product_id" name="product_id">
		</div>
		<div>
			<span>이름</span> <input type="text" id="name" name="name">
		</div>
		<div>
			<span>가격</span> <input type="text" id="price" name="price">
		</div>
		<div>
			<span>종류</span> <input type="text" id="type" name="type">
		</div>
		<h2 id="result"></h2>

	</form>
	<script>
		$('#listBtn').on('click', function() {
			$.ajax({
				url : "product",
				type : "POST",
				data : JSON.stringify(form),
				contentType : "application/json; charset=utf-8;",
				dataType : "json",
				success : function(data) {
					$("#productList").empty();
					data.forEach(function(product){
						$("#productList").append('<li id="product_id\${product.product_id}">\${product.product_id}</li>');
					})
		
				},
				error : function() {
					alert("err");
				}
			});
		});
		$("#addBtn").click(function () {
			$.ajax({
				url: "insertProduct",
				type: "POST",
				data: $("#inputForm").serialize(),
				success: function(data) {
					$("#productList").empty();
					data.forEach(function(product){
						$("#productList").append('<li id="product_id\${product.product_id}">\${product.product_id}</li>');
					})
					$("#product_id").val("");
					$("#name").val("");
					$("#price").val("");
					$("#type").val("");
					$("#result").text("등록 성공");
				}
			});
		});
		
		$("#delBtn").click(function () {
			const product_id = $("#product_id").val();
			$.ajax({
				url: "removeProduct",
				data: {
					product_id: product_id
				},
				success: function(data) {
					console.dir(data);
					$(`#product_id\${product_id}`).remove();
					$("#product_id").val("");
					$("#name").val("");
					$("#price").val("");
					$("#type").val("");
					$("#result").text("삭제 성공");
					currentId = "";
				}
			});
		});
	</script>

</body>
</html>