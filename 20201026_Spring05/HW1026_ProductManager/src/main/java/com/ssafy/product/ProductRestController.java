package com.ssafy.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.product.model.ProductDto;
import com.ssafy.product.model.SearchDto;
import com.ssafy.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	ProductService productService;

	@GetMapping(value = "list", headers = { "Content-type=application/json" })
	public String list(@RequestParam(value = "searchType", required = false) String searchType,
			@RequestParam(value = "searchWord", required = false) String searchWord, Model model) {

		List<ProductDto> list = productService.allProduct(new SearchDto(searchWord, searchType));
		model.addAttribute("products", list);
		return "list";
	}

	@GetMapping(value = "removeProduct", headers = { "Content-type=application/json" })
	public String delete(@RequestParam("product_id") int product_id, Model model) {
		productService.deleteProduct(product_id);
		return "redirect:list?searchType=&searchWord=";
	}

	@PostMapping(value = "insertProduct", headers = { "Content-type=application/json" })
	public String add(ProductDto productDto, Model model) {
		productService.addProduct(productDto);
		return "redirect:list?searchType=&searchWord=";
	}

}
