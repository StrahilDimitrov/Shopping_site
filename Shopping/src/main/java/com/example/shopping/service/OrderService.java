package com.example.shopping.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shopping.model.entity.OrderEntity;
import com.example.shopping.model.entity.OrderItemEntity;
import com.example.shopping.model.entity.ShoppingCartEntity;
import com.example.shopping.model.entity.ShoppingItemEntity;
import com.example.shopping.model.entity.UserEntity;
import com.example.shopping.repository.OrderItemRepository;
import com.example.shopping.repository.OrderRepository;
import com.example.shopping.repository.ShoppingCartRepository;
import com.example.shopping.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;
	private final ShoppingCartRepository shoppingCartRepository;
	private final UserRepository userRepository;

	public OrderService(OrderRepository orderRepository, ShoppingCartRepository shoppingCartRepository,
			UserRepository userRepository, OrderItemRepository orderItemRepository) {
		this.orderRepository = orderRepository;
		this.orderItemRepository = orderItemRepository;
		this.shoppingCartRepository = shoppingCartRepository;
		this.userRepository = userRepository;
	}

	@Transactional
	public void placeOrder(String email) {
		UserEntity user = this.userRepository.findByEmail(email).get();

		ShoppingCartEntity cart = this.shoppingCartRepository.findByUser(user).orElse(null);

		BigDecimal total = calculateTotalCost(cart);

		OrderEntity order = new OrderEntity();
		order.setCustomer(user).setDate(LocalDateTime.now()).setOrderCost(total);

		order = this.orderRepository.save(order);
		
		List<OrderItemEntity> items = new ArrayList<>();

		for (ShoppingItemEntity item : cart.getItems()) {
			items.add(new OrderItemEntity(item.getProduct(), order));
		}

		this.orderItemRepository.saveAll(items);

	}

	private BigDecimal calculateTotalCost(ShoppingCartEntity cart) {
		BigDecimal total = new BigDecimal("0.0");

		for (ShoppingItemEntity item : cart.getItems()) {
			total = total.add(BigDecimal.valueOf(item.getQuantity()).multiply(item.getProduct().getPrice()));
		}

		return total;
	}
}
