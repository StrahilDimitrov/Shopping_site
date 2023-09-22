package com.example.shopping.model.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private UserEntity customer;

	@OneToMany(mappedBy = "shoppingOrder")
	private List<OrderItemEntity> items;

	@Column
	private LocalDate date;

	public OrderEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getCustomer() {
		return customer;
	}

	public void setCustomer(UserEntity customer) {
		this.customer = customer;
	}

	public List<OrderItemEntity> getItems() {
		return items;
	}

	public void setItems(List<OrderItemEntity> items) {
		this.items = items;
	}

	public LocalDate getDate() {
		return date;
	}

	public OrderEntity setDate(LocalDate date) {
		this.date = date;
		return this;
	}
}
