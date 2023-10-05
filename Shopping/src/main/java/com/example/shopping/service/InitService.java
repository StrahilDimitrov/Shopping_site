package com.example.shopping.service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shopping.model.entity.CategoryEntity;
import com.example.shopping.model.entity.ProductEntity;
import com.example.shopping.model.enums.Category;
import com.example.shopping.repository.CategoryRepository;
import com.example.shopping.repository.ProductRepository;
import com.google.gson.Gson;

@Service
public class InitService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final Gson gson;

	public InitService(ProductRepository productRepository, CategoryRepository categoryRepository, Gson gson) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.gson = gson;
	}

	public void initDb() throws IOException {
		if (categoryRepository.count() == 0) {
			List<CategoryEntity> categories = new ArrayList<>();

			for (Category c : Category.values()) {
				categories.add(new CategoryEntity(c));
			}

			this.categoryRepository.saveAll(categories);
		}

		FileReader reader = new FileReader(
				Path.of("src", "main", "resources", "static", "js", "products.json").toFile());

		ProductEntity[] products = gson.fromJson(reader, ProductEntity[].class);

		reader.close();

		if (productRepository.count() == 0) {
			productRepository.saveAll(List.of(products));
		}

	}

}
