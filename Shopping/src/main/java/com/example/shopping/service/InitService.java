package com.example.shopping.service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shopping.model.entity.ProductEntity;
import com.example.shopping.repository.OrderItemRepository;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.ShoppingItemRepository;
import com.example.shopping.repository.SpecificationsRepository;
import com.google.gson.Gson;

@Service
public class InitService {
	private final ProductRepository productRepository;
	private final SpecificationsRepository specificationsRepositor;
	private final Gson gson;
	private final ShoppingItemRepository shoppingItemRepository;
	private final OrderItemRepository orderItemRepository;

	public InitService(ProductRepository productRepository, Gson gson, SpecificationsRepository specificationsRepositor, ShoppingItemRepository shoppingItemRepository, OrderItemRepository orderItemRepository) {
		this.productRepository = productRepository;
		this.specificationsRepositor = specificationsRepositor;
		this.gson = gson;
		this.shoppingItemRepository = shoppingItemRepository;
		this.orderItemRepository = orderItemRepository;
	}

	public void initDb() {
		try (FileReader reader = new FileReader(
				Path.of("src", "main", "resources", "static", "js", "products.json").toFile())) {
			List<ProductEntity> products = Arrays.stream(gson.fromJson(reader, ProductEntity[].class)).toList();

			reader.close();

			if (productRepository.count() < products.size()) {
				this.orderItemRepository.deleteAll();
				this.shoppingItemRepository.deleteAll();
				this.specificationsRepositor.deleteAll();
				this.productRepository.deleteAll();
				
				
				products = this.productRepository.saveAll(products);

				for (ProductEntity product : products) {
					product.getSpecs().forEach(sp -> {
						sp.setProduct(product);
						this.specificationsRepositor.save(sp);
					});
				}
			}
		} catch (IOException e) {
			System.out.println("File does't exist!");
		}
//		CategoryEntity cat = categoryRepository.findById(5l).get();
//
//		ProductEntity prod = new ProductEntity();
//		prod.setPrice(BigDecimal.valueOf(1234)).setProductName("ASUS").setQuantity(15).setDescription("Good Laptop")
//				.setCategory(cat);
//
//		prod = this.productRepository.save(prod);
//
//		SpecificationsEntity spec1 = new SpecificationsEntity("Ram", "8GB", prod);
//		SpecificationsEntity spec2 = new SpecificationsEntity("CPU", "INTEL CORE I7", prod);
//		SpecificationsEntity spec3 = new SpecificationsEntity("GPU", "NVIDIA RTX 4060", prod);
//
//		this.specificationsRepositor.saveAll(List.of(spec1, spec2, spec3));
//
//		this.specificationsRepositor.findAllByProductId(prod.getId())
//				.forEach(p -> System.out.println(p.getName() + " -> " + p.getValue()));

	}

}
