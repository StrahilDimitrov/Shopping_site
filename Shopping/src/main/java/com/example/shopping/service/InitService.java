package com.example.shopping.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shopping.model.entity.CategoryEntity;
import com.example.shopping.model.entity.ProductEntity;
import com.example.shopping.model.enums.Category;
import com.example.shopping.repository.CategoryRepository;
import com.example.shopping.repository.ProductRepository;

@Service
public class InitService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public InitService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public void initDb() {
		if (categoryRepository.count() == 0) {
			List<CategoryEntity> categories = new ArrayList<>();

			for (Category c : Category.values()) {
				categories.add(new CategoryEntity(c));
			}

			this.categoryRepository.saveAll(categories);
		}

		ProductEntity productEntity1 = new ProductEntity("ASUS VIVOBOOK", BigDecimal.valueOf(1399.0), "Good laptop", 10,
				"/images/asus.png", categoryRepository.findByName(Category.LAPTOPS).get());

		ProductEntity productEntity2 = new ProductEntity("Acer NITRO 5", BigDecimal.valueOf(1299.0), "Good smartphone",
				15, "/images/acer.png", categoryRepository.findByName(Category.SMARTPHONES).get());

		ProductEntity productEntity3 = new ProductEntity("ASUS VIVOBOOK 5 ", BigDecimal.valueOf(2000.0), "Good laptop",
				14, "/images/huaweiP50.png", categoryRepository.findByName(Category.LAPTOPS).get());

		if (productRepository.count() == 0) {
			productRepository.save(productEntity1);
			productRepository.save(productEntity2);
			productRepository.save(productEntity3);
		}

	}

}
