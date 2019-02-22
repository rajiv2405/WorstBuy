/**
 * 
 */
package com.shop.worstBuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.worstBuy.component.ItemResponse;
import com.shop.worstBuy.component.Product;
import com.shop.worstBuy.component.ShoppingRequest;
import com.shop.worstBuy.component.ShoppingResponse;
import com.shop.worstBuy.service.ShoppingService;

/**
 * @author ranichal
 *
 */
@RestController
@RequestMapping("worstBuy")
public class ShoppingController {
	@Autowired
	public ShoppingService service;
	
	
	@GetMapping("/retrieve")
	public List<Product> retrieveProductList(){
		List<Product> productList = service.retrieveProducts();	
		return productList;
	}
	
	@PostMapping("/update")
	public ShoppingResponse purchaseItems(ShoppingRequest request) {
		ShoppingResponse response = new ShoppingResponse();
		List <ItemResponse> itemList = service.updateProducts(request);
		response.setItemResponse(itemList);
		return response;
		
	}
}
