package com.example.shopping.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.shopping.model.entity.ProductEntity;
import com.example.shopping.repository.ProductRepository;

@Service
public class InitService {
	private final ProductRepository productRepository;

	public InitService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void initDb() {
		ProductEntity productEntity1 = new ProductEntity("ASUS VIVOBOOK", BigDecimal.valueOf(1399.0), "Good laptop",
				10);

		ProductEntity productEntity2 = new ProductEntity("Acer NITRO 5", BigDecimal.valueOf(1299.0), "Good smartphone",
				15);

		ProductEntity productEntity3 = new ProductEntity("ASUS VIVOBOOK 5 ", BigDecimal.valueOf(2000.0), "Good laptop",
				14);

		if (productRepository.count() == 0) {
			productRepository.save(productEntity1);
			productRepository.save(productEntity2);
			productRepository.save(productEntity3);
		}

	}

}
