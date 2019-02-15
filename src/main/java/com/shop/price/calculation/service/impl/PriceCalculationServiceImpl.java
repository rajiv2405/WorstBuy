package com.shop.price.calculation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shop.price.calculation.service.PriceCalculationService;
import com.shop.worstBuy.component.ItemResponse;


@Service
public class PriceCalculationServiceImpl implements PriceCalculationService {
		
	private static final double DISCOUNT_WITH_INSURANCE_ABOVE_400 = .25;

	private static final double DISCOUNT_ON_PHONE_WITH_INSURANCE = .15;

	private static final double DISCOUNT_ON_SAMZUNG_PRODUCT = .1;

	private static final double VAT = .14;

	private List<Long> phoneList = new ArrayList<Long>();
	{
		phoneList.add(new Long(1));
		phoneList.add(new Long(2));
		phoneList.add(new Long(3));
	}
		
	public Double calculateTotalPriceWithDiscountAndVAT(int numOfItemsPurchased,
			com.shop.worstBuy.entity.Product availableProduct, boolean isInsuranceOpted) {
		double discountOffered = 0.0;
		double totalPriceWithDiscount = 0.0;
		double totalPriceWithoutDiscount = numOfItemsPurchased * availableProduct.getPricePerproduct();
		if (isInsuranceOpted) {
			if (availableProduct.getPricePerproduct() > 400)
				discountOffered = DISCOUNT_WITH_INSURANCE_ABOVE_400;
			else if (phoneList.contains(availableProduct.getId()))
				discountOffered = DISCOUNT_ON_PHONE_WITH_INSURANCE;
		}
		if (availableProduct.getName().contains("SamZung")) {
			discountOffered += DISCOUNT_ON_SAMZUNG_PRODUCT;
		}
		totalPriceWithDiscount -= totalPriceWithoutDiscount * discountOffered;

		if (!isInsuranceOpted) {
			totalPriceWithDiscount += totalPriceWithDiscount * VAT;
		}
		return totalPriceWithDiscount;
	}
		
}
