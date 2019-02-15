/**
 * 
 */
package com.shop.worstBuy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.price.calculation.service.PriceCalculationService;
import com.shop.price.calculation.service.impl.PriceCalculationServiceImpl;
import com.shop.worstBuy.component.ItemRequest;
import com.shop.worstBuy.component.ItemResponse;
import com.shop.worstBuy.component.Product;
import com.shop.worstBuy.component.ShoppingRequest;
import com.shop.worstBuy.repository.ProductRepository;
import com.shop.worstBuy.service.ShoppingService;

/**
 * @author ranichal
 *
 */
@Service
public class ShoppingServiceImpl implements ShoppingService {
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private PriceCalculationService calculateService;

	private Map<Long, Long> offerMap = new HashMap<Long, Long>();
	{
		offerMap.put(new Long(1), new Long(4));
		offerMap.put(new Long(4), new Long(4));
		offerMap.put(new Long(8), new Long(8));
	}
	
	public List<Product> retrieveProducts() {
		List<com.shop.worstBuy.entity.Product> products = repository.findAll();
		List<Product> productDTOs = products.stream().map(product -> {
			Product productDto = new Product();
			productDto.setId(product.getId());
			productDto.setProductName(product.getName());
			productDto.setPricePerItem(product.getPricePerproduct());
			productDto.setNumOfProductsAvailable(product.getProductCount());
			return productDto;
		}).collect(Collectors.toList());
		return productDTOs;
	}

	public List<ItemResponse> updateProducts(ShoppingRequest request) {
		Map<Long, Integer> freeMap = new HashMap<Long, Integer>();

		List<ItemResponse> itemList = new ArrayList<ItemResponse>();
		Map<String, ItemResponse> itemRespMap = new HashMap<String, ItemResponse>();
		if (request.getItemRequest() != null && !request.getItemRequest().isEmpty()) {
			for (ItemRequest itemRequest : request.getItemRequest()) {
				if (itemRequest.getId().equals(new Long(4)) && itemRequest.getQuantity() > 10) {
					throw new RuntimeException("You cannot buy more than 10 sim cards at a time");
				}
				updateProductAndPrepareShoppingReceipt(itemRequest.getId(), itemRequest.getQuantity(), itemRespMap,
						false, itemRequest.isInsuraceOpted());
				prepareFreeItem(itemRequest, freeMap);
			}
		}else {
		    throw new RuntimeException("Please add the product in the shopping bag");
		}

		updateFreeItemAndShoppingReceipt(freeMap, itemRespMap);

		itemList = itemRespMap.values().stream().collect(Collectors.toList());
		return itemList;

	}

	private void updateFreeItemAndShoppingReceipt(Map<Long, Integer> freeMap, Map<String, ItemResponse> itemRespMap) {
		Iterator<Entry<Long, Integer>> iterator = freeMap.entrySet().iterator();
		if (iterator.hasNext()) {
			Map.Entry<Long, Integer> entry = (Map.Entry<Long, Integer>) iterator.next();
			updateProductAndPrepareShoppingReceipt((Long) entry.getKey(), (Integer) entry.getValue(), itemRespMap, true,
					false);
		}
	}

	private void prepareFreeItem(ItemRequest itemRequest, Map<Long, Integer> freeMap) {
		int NumOfProductFree = 0;
		if (offerMap.containsKey(itemRequest.getId())) {

			if (itemRequest.getId().equals(new Long(8))) {
				NumOfProductFree = itemRequest.getQuantity() / 3;
			} else {
				NumOfProductFree = itemRequest.getQuantity();
			}
			if (NumOfProductFree > 0)
				freeMap.put(offerMap.get(itemRequest.getId()), NumOfProductFree);
		}
	}

	private void updateProductAndPrepareShoppingReceipt(Long productId, int numOfItemsPurchased,
			Map<String, ItemResponse> itemRespMap, boolean isItemFree, boolean isInsuranceOpted) {

		double totalPriceWithDiscount = 0.0;
		com.shop.worstBuy.entity.Product updatedProduct = null;
		Optional<com.shop.worstBuy.entity.Product> availableProduct = repository.findById(productId);
		if (availableProduct.isPresent()) {
			int numOfProductAvailable = availableProduct.get().getProductCount();
			numOfProductAvailable -= numOfItemsPurchased;
			availableProduct.get().setProductCount(numOfProductAvailable);
			updatedProduct = repository.save(availableProduct.get());

			if (!isItemFree) {
				totalPriceWithDiscount = calculateService.calculateTotalPriceWithDiscountAndVAT(numOfItemsPurchased,
						availableProduct.get(), isInsuranceOpted);
			}
			ItemResponse item = prepareItemForShoppingReceipt(itemRespMap, updatedProduct, numOfItemsPurchased,
					totalPriceWithDiscount);

			itemRespMap.put(item.getName(), item);

		} else {
			throw new RuntimeException("Out of Stock! Item is not available in the shop");
		}
	}
	
	private ItemResponse prepareItemForShoppingReceipt(Map<String, ItemResponse> itemRespMap,
			com.shop.worstBuy.entity.Product updatedProduct, int numOfItemsPurchased, double totalPriceWithDiscount) {
		if (itemRespMap.containsKey(updatedProduct.getName()) && itemRespMap.get(updatedProduct.getName()) != null) {
			numOfItemsPurchased += itemRespMap.get(updatedProduct.getName()).getQuantity();
		}
		ItemResponse item = new ItemResponse();
		item.setName(updatedProduct.getName());
		item.setPricePerItem(updatedProduct.getPricePerproduct());
		item.setQuantity(numOfItemsPurchased);
		item.setTotalPriceWithDiscount(totalPriceWithDiscount);
		return item;
	}

}
