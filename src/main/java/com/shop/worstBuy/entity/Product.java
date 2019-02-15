/**
 * 
 */
package com.shop.worstBuy.entity;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



/**
 * @author ranichal
 *
 */
@Entity
public class Product {
	@Id
	@GeneratedValue
	@Column (name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PRODUCT_COUNT")
	private int productCount;
	@Column(name = "PRICE_PER_PRODUCT")
	private int pricePerproduct;
	
	public Product() {
		
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
	 * @return the productCount
	 */
	public int getProductCount() {
		return productCount;
	}
	/**
	 * @param productCount the productCount to set
	 */
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	/**
	 * @return the pricePerproduct
	 */
	public int getPricePerproduct() {
		return pricePerproduct;
	}
	/**
	 * @param pricePerproduct the pricePerproduct to set
	 */
	public void setPricePerproduct(int pricePerproduct) {
		this.pricePerproduct = pricePerproduct;
	} 
	
	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", name=" + name + ", productCount='" + productCount + '\'' + ", pricePerproduct='" + pricePerproduct
				+ '\'' + '}';
	}

}
