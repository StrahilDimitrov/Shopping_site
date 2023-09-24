package com.example.shopping.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopping.model.entity.ProductEntity;
import com.example.shopping.model.entity.ShoppingCartEntity;
import com.example.shopping.model.entity.ShoppingItemEntity;
import com.example.shopping.model.entity.UserEntity;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.ShoppingCartRepository;
import com.example.shopping.repository.ShoppingItemRepository;
import com.example.shopping.repository.UserRepository;

@Service
public class ShoppingCartService {
	private final UserRepository userRepository;
	private final ShoppingCartRepository shoppingCartRepository;
	private final ShoppingItemRepository shoppingItemRepository;
	private final ProductRepository productRepository;

	public ShoppingCartService(UserRepository userRepository, ShoppingCartRepository shoppingCartRepository,
			ProductRepository productRepository, ShoppingItemRepository shoppingItemRepository) {
		this.userRepository = userRepository;
		this.shoppingCartRepository = shoppingCartRepository;
		this.shoppingItemRepository = shoppingItemRepository;
		this.productRepository = productRepository;
	}

	public void addToCart(Long id, String email) {
		UserEntity user = userRepository.findByEmail(email).get();

		ShoppingCartEntity cart = shoppingCartRepository.findByUser(user).orElse(new ShoppingCartEntity(user));

		cart = shoppingCartRepository.save(cart);

		ProductEntity product = productRepository.findById(id).orElse(null);

		ShoppingItemEntity shoppingItem = new ShoppingItemEntity();
		shoppingItem.setProduct(product).setCart(cart).setQuantity(1);

		shoppingItemRepository.save(shoppingItem);
	}

	@Transactional
	public void deleteCart(String email) {
		UserEntity user = userRepository.findByEmail(email).get();
		this.shoppingCartRepository.deleteByUser(user);

	}
}
