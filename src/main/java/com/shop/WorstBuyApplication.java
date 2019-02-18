package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.shop.*")
@EnableJpaRepositories("com.shop.worstBuy.repository") 
@EntityScan("com.shop.worstBuy.entity")
public class WorstBuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorstBuyApplication.class, args);
	}
}
