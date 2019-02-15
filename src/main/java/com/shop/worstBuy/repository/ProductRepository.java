package com.shop.worstBuy.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.worstBuy.entity.Product;

/**
 * 
 */

/**
 * @author ranichal
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
