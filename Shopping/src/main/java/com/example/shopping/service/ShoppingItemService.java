package com.example.shopping.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.shopping.model.dto.ApplicationUserDetails;
import com.example.shopping.model.dto.ShoppingCartDto;
import com.example.shopping.model.dto.ShoppingCartItemDto;
import com.example.shopping.model.entity.ShoppingCartEntity;
import com.example.shopping.model.entity.ShoppingItemEntity;
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

	public void removeItemById(Long id) {
		ShoppingItemEntity item = this.itemRepository.findById(id).get();

		if (item.getQuantity() > 1) {
			item.setQuantity(item.getQuantity() - 1);
			this.itemRepository.save(item);

		} else {
			this.itemRepository.deleteById(id);
		}
	}

	public void loadShoppingCart(ModelAndView modelAndView, @AuthenticationPrincipal ApplicationUserDetails user) {
		List<ShoppingCartItemDto> cartItems = new ArrayList<>();

		if (user != null) {
			cartItems = getAllItemsByUser(user.getUsername());
		}

		BigDecimal total = new BigDecimal(0);

		for (ShoppingCartItemDto item : cartItems) {
			total = total.add(item.getAmount());
		}

		modelAndView.addObject("total", total);
		modelAndView.addObject("cartItems", cartItems);
	}

	public ShoppingCartDto getShoppingCart(@AuthenticationPrincipal ApplicationUserDetails user) {
		List<ShoppingCartItemDto> cartItems = new ArrayList<>();

		if (user != null) {
			cartItems = getAllItemsByUser(user.getUsername());
		}

		BigDecimal total = new BigDecimal(0);

		for (ShoppingCartItemDto item : cartItems) {
			total = total.add(item.getAmount());
		}

		ShoppingCartDto shoppingCartDto = new ShoppingCartDto(cartItems, total);

		return shoppingCartDto;
	}
}
