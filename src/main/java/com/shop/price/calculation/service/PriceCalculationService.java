package com.shop.price.calculation.service;

public interface PriceCalculationService {

	public Double calculateTotalPriceWithDiscountAndVAT(int numOfItemsPurchased,
			com.shop.worstBuy.entity.Product availableProduct, boolean isInsuranceOpted);
	
}
