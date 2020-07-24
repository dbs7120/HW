package com.ssafy.Product;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {

		ProductMgr mgr = ProductMgr.getInstance();
		Scanner sc = new Scanner(System.in);
		int menu;
		
		mgr.add(new Product(123123, "냉장고", 320000, 3));
		mgr.add(new Product(321321, "청소기", 123000, 5));
		mgr.add(new Product(444444, "스마트TV", 888888, 5));

		while (true) {
			System.out.println("<<< ABC디지털 대리점 재고관리 >>>");
			System.out.println("1. 상품저장");
			System.out.println("2. 상품리스트 출력");
			System.out.println("3. 상품번호로 검색");
			System.out.println("4. 상품번호로 삭제");
			System.out.println("5. 특정가격 이하 상품 검색");
			System.out.println("0. 종료");
			menu = sc.nextInt();
			sc.nextLine();

			String proName;
			int proNum, proPrice, proAmount;
			switch (menu) {
			case 1:
				System.out.print(">상품 번호: ");
				proNum = sc.nextInt();
				sc.nextLine();
				System.out.print(">상품 이름: ");
				proName = sc.nextLine();
				System.out.print(">상품 가격: ");
				proPrice = sc.nextInt();
				sc.nextLine();
				System.out.print(">상품 수량: ");
				proAmount = sc.nextInt();
				sc.nextLine();
				mgr.add(new Product(proNum, proName, proPrice, proAmount));
				break;
			case 2:
				System.out.println(">상품리스트 출력");
				for (Product m : mgr.list()) {
					if (m != null)
						System.out.println(m);
				}
				break;
			case 3:
				System.out.println(">상품번호로 검색");
				System.out.print(">상품 번호 입력: ");
				proNum = sc.nextInt();

				System.out.println(mgr.list(proNum));
				break;
			case 4:
				System.out.println(">상품번호로 삭제");
				System.out.print(">상품 번호 입력: ");
				proNum = sc.nextInt();
				mgr.delete(proNum);
				break;
			case 5:
				System.out.println(">특정가격 이하 상품 검색");
				System.out.print(">상품가격 입력: ");
				proPrice = sc.nextInt();
				sc.nextLine();
				for (Product m : mgr.priceList(proPrice)) {
					if (m != null) {
						System.out.println(m);
					}
				}
				break;
			case 0:
				System.out.println("프로그램 종료");
				break;
			}

			if (menu == 0)
				break;
		}
		sc.close();
	}
}