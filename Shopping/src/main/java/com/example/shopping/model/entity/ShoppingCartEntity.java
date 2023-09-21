package com.example.shopping.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private UserEntity user;

	@OneToMany(mappedBy = "cartId", targetEntity = ShoppingItemEntity.class)
	private List<ShoppingItemEntity> items;

}
