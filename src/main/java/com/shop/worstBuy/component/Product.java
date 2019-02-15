/**
 * 
 */
package com.shop.worstBuy.component;

/**
 * @author ranichal
 *
 */

public class Product {

	private Long id;
	private String productName;
	private int NumOfProductsAvailable;
	private int pricePerItem;
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the numOfProductsAvailable
	 */
	public int getNumOfProductsAvailable() {
		return NumOfProductsAvailable;
	}
	/**
	 * @param numOfProductsAvailable the numOfProductsAvailable to set
	 */
	public void setNumOfProductsAvailable(int numOfProductsAvailable) {
		NumOfProductsAvailable = numOfProductsAvailable;
	}
	/**
	 * @return the pricePerItem
	 */
	public int getPricePerItem() {
		return pricePerItem;
	}
	/**
	 * @param pricePerItem the pricePerItem to set
	 */
	public void setPricePerItem(int pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	
	public String toString() {
		return this.id + " "+ this.productName + " "+  this.pricePerItem + " " + this.NumOfProductsAvailable;
	}

}
