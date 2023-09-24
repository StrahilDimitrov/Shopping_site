package com.example.shopping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.shopping.model.dto.ShoppingCartItemDto;
import com.example.shopping.model.entity.ShoppingCartEntity;
import com.example.shopping.model.entity.UserEntity;
import com.example.shopping.repository.ShoppingCartRepository;
import com.example.shopping.repository.ShoppingItemRepository;
import com.example.shopping.repository.UserRepository;

@Service
public class ShoppingItemService {
	private final ShoppingItemRepository itemRepository;
	private final ShoppingCartRepository shoppingCartRepository;
	private final UserRepository userRepository;

	public ShoppingItemService(ShoppingItemRepository itemRepository, UserRepository userRepository,
			ShoppingCartRepository shoppingCartRepository) {
		this.itemRepository = itemRepository;
		this.shoppingCartRepository = shoppingCartRepository;
		this.userRepository = userRepository;
	}

	public List<ShoppingCartItemDto> getAllItemsByUser(String email) {
		UserEntity user = this.userRepository.findByEmail(email).orElse(null);
		ShoppingCartEntity cart = this.shoppingCartRepository.findByUser(user).orElse(null);

		List<ShoppingCartItemDto> items = this.itemRepository.findAllByCart(cart).get().stream()
				.map(ShoppingCartItemDto::mapToShoppingItemDto).collect(Collectors.toList());

		return items;
	}

	public void deleteItemById(Long id) {
		this.itemRepository.deleteById(id);

	}
}
