/**
 * 
 */
package com.shop.worstBuy.component;

import java.util.List;

/**
 * @author ranichal
 *
 */
public class ShoppingRequest {

	List<ItemRequest> itemRequest;

	/**
	 * @return the itemRequest
	 */
	public List<ItemRequest> getItemRequest() {
		return itemRequest;
	}

	/**
	 * @param itemRequest the itemRequest to set
	 */
	public void setItemRequest(List<ItemRequest> itemRequest) {
		this.itemRequest = itemRequest;
	}
	
}
