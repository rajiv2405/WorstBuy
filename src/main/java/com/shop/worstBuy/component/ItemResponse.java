/**
 * 
 */
package com.shop.worstBuy.component;

/**
 * @author ranichal
 *
 */
public class ItemResponse {
	private String name;
	private int quantity;
	private float pricePerItem;
	private float disount;
	private double totalPriceWithDiscount;
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
	 * @return the pricePerItem
	 */
	public float getPricePerItem() {
		return pricePerItem;
	}
	/**
	 * @param pricePerItem the pricePerItem to set
	 */
	public void setPricePerItem(float pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	/**
	 * @return the disount
	 */
	public float getDisount() {
		return disount;
	}
	/**
	 * @param disount the disount to set
	 */
	public void setDisount(float disount) {
		this.disount = disount;
	}
	/**
	 * @return the totalPriceWithDiscount
	 */
	public double getTotalPriceWithDiscount() {
		return totalPriceWithDiscount;
	}
	
	public void setTotalPriceWithDiscount(double totalPriceWithDiscount) {
		// TODO Auto-generated method stub
		this.totalPriceWithDiscount = totalPriceWithDiscount;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ItemResponse) {
			ItemResponse resp = (ItemResponse)obj;
			if(this.getName().equalsIgnoreCase(resp.getName())) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return " name: "+ name + " quantity: "+ quantity + " pricePerItem: "+pricePerItem+ " disount: "+disount+ " TotalPriceWithDiscount: "+ totalPriceWithDiscount;
	}
	
}
