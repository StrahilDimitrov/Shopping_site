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
		List<ProductEntity> products = new ArrayList<>();
		
		products.add(new ProductEntity("ASUS VIVOBOOK", BigDecimal.valueOf(1399.0), "Good laptop", 10,
				"/images/asus.png", categoryRepository.findByName(Category.LAPTOPS).get()));
		
		products.add(new ProductEntity("Acer NITRO 5", BigDecimal.valueOf(1299.0), "Good smartphone", 15,
				"/images/acer.png", categoryRepository.findByName(Category.SMARTPHONES).get()));

		products.add(new ProductEntity("ASUS VIVOBOOK 5", BigDecimal.valueOf(2000.0), "Good laptop", 14,
				"/images/huaweiP50.png", categoryRepository.findByName(Category.LAPTOPS).get()));
		
		products.add(new ProductEntity("ACER VERITON S2680G", BigDecimal.valueOf(599.0), "Good computer", 11,
				"/images/computer Page/comp1.jpg", categoryRepository.findByName(Category.COMPUTERS).get()));

		products.add(new ProductEntity("APPLE MAC MINI", BigDecimal.valueOf(899.0), "Good computer", 17,
				"/images/computer Page/comp4.jpg", categoryRepository.findByName(Category.COMPUTERS).get()));
		
		products.add(new ProductEntity("ACER Nitro N50-640", BigDecimal.valueOf(1399.0), "Good computer", 12,
				"/images/computer Page/comp2.jpg", categoryRepository.findByName(Category.COMPUTERS).get()));

		products.add(new ProductEntity("ASUS G10CE-21403", BigDecimal.valueOf(1599.0), "Good computer", 12,
				"/images/computer Page/comp5.jpg", categoryRepository.findByName(Category.COMPUTERS).get()));
		
		products.add(new ProductEntity("ACER PREDATOR PO3-630", BigDecimal.valueOf(2399.0), "Good computer", 7,
				"/images/computer Page/comp3.jpg", categoryRepository.findByName(Category.COMPUTERS).get()));
		
		products.add(new ProductEntity("ASUS ROG Strix G15DK-WB5520", BigDecimal.valueOf(2199.0), "Good computer", 7,
				"/images/computer Page/comp6.jpg", categoryRepository.findByName(Category.COMPUTERS).get()));
		
		products.add(new ProductEntity("GPLAY OFFICETHON", BigDecimal.valueOf(599.0), "Good computer", 20,
				"/images/computer Page/comp7.jpg", categoryRepository.findByName(Category.COMPUTERS).get()));
		
		products.add(new ProductEntity("LENOVO T540-15ICK", BigDecimal.valueOf(999.0), "Good computer", 15,
				"/images/computer Page/comp8.jpg", categoryRepository.findByName(Category.COMPUTERS).get()));
		
		products.add(new ProductEntity("Dell OptiPlex 7010", BigDecimal.valueOf(1469.0), "Good computer", 10,
				"/images/computer Page/comp9.jpg", categoryRepository.findByName(Category.COMPUTERS).get()));
		
		products.add(new ProductEntity("HP Z440 Workstation", BigDecimal.valueOf(2439.0), "Good computer", 16,
				"/images/computer Page/comp10.jpg", categoryRepository.findByName(Category.COMPUTERS).get()));
		
		products.add(new ProductEntity("MSI Cubi N ADL-002EU", BigDecimal.valueOf(459.0), "Good computer", 12,
				"/images/computer Page/comp11.jpg", categoryRepository.findByName(Category.COMPUTERS).get()));
		
		products.add(new ProductEntity("GIGABYTE Brix BRR3-4300", BigDecimal.valueOf(499.0), "Good computer", 18,
				"/images/computer Page/comp12.jpg", categoryRepository.findByName(Category.COMPUTERS).get()));


		if (productRepository.count() == 0) {
			productRepository.saveAll(products);
		}

	}

}
