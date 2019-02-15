/**
 * 
 */
package com.shop.worstBuy.component;

/**
 * @author ranichal
 *
 */
public class ItemRequest {
	private Long id;
	private String name;
	private int quantity;
	private boolean insuraceOpted;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the insuraceOpted
	 */
	public boolean isInsuraceOpted() {
		return insuraceOpted;
	}
	/**
	 * @param insuraceOpted the insuraceOpted to set
	 */
	public void setInsuraceOpted(boolean insuraceOpted) {
		this.insuraceOpted = insuraceOpted;
	}
	
}
