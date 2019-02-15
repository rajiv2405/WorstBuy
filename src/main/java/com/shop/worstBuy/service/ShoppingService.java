/**
 * 
 */
package com.shop.worstBuy.service;

import java.util.List;

import com.shop.worstBuy.component.ItemResponse;
import com.shop.worstBuy.component.ShoppingRequest;

/**
 * @author ranichal
 *
 */
public interface ShoppingService {
	
	public List<com.shop.worstBuy.component.Product> retrieveProducts();
	
	public List<ItemResponse> updateProducts(ShoppingRequest request);
	

}
