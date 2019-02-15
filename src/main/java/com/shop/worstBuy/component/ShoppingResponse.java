/**
 * 
 */
package com.shop.worstBuy.component;

import java.util.List;

/**
 * @author ranichal
 *
 */
public class ShoppingResponse {
	List<ItemResponse> itemResponse;
	double totalPrice;
	/**
	 * @return the itemResponse
	 */
	public List<ItemResponse> getItemResponse() {
		return itemResponse;
	}
	/**
	 * @param itemResponse the itemResponse to set
	 */
	public void setItemResponse(List<ItemResponse> itemResponse) {
		this.itemResponse = itemResponse;
	}
	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
