package com.ssafy.Product;

public class ProductMgr {
	private Product[] product = new Product[100];
	private int index;

	static ProductMgr promgr = null;

	private ProductMgr() {
	}

	static ProductMgr getInstance() {
		if (promgr == null) {
			promgr = new ProductMgr();
		}
		return promgr;
	}

	public void add(Product p) {
		product[index] = new Product(p.getProNum(), p.getProName(), p.getProPrice(), p.getProAmount());
		index++;
	}

	public Product[] list() {
		return product;
	}

	public Product list(int num) {
		for (int i = 0; i < index; i++) {
			if ((product[i].getProNum() == num)) {
				return product[i];
			}
		}
		return null;

	}

	public void delete(int num) {
		for (int i = 0; i < index - 2; i++) {
			if (product[i].getProNum() == num) {
				product[i] = product[i + 1];
				product[i + 1] = product[i + 2];
				index--;
				break;
			}
		}
	}

	public Product[] priceList(int price) {
		Product[] temp = new Product[100];

		int j = 0;
		for (int i = 0; i < index; i++) {
			if ((product[i].getProPrice() <= price)) {
				temp[j] = product[i];
				j++;
			}

		}
		return temp;
	}

}
