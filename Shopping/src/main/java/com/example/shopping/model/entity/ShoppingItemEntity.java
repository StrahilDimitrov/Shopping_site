package com.example.shopping.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_cart_items")
public class ShoppingItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private ProductEntity product;

	@ManyToOne
	private ShoppingCartEntity cartId;

	@Column
	private int quantity;

	@Column
	private BigDecimal amount;

	public ShoppingItemEntity() {

	}

	public Long getId() {
		return id;
	}

	public ShoppingItemEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public ShoppingItemEntity setProduct(ProductEntity product) {
		this.product = product;
		return this;
	}

	public ShoppingCartEntity getCartId() {
		return cartId;
	}

	public ShoppingItemEntity setCartId(ShoppingCartEntity cartId) {
		this.cartId = cartId;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public ShoppingItemEntity setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public ShoppingItemEntity setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

}
