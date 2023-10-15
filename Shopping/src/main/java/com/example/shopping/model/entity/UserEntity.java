package com.example.shopping.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String email;

	@Column
	private String password;

	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany(mappedBy = "customer")
	private List<OrderEntity> orders;

	@OneToMany(mappedBy = "user")
	private List<CreditCardEntity> cards;

	@OneToMany(mappedBy = "user")
	private List<AddressEntity> deliveryAddresses;

	public UserEntity() {
		orders = new ArrayList<>();
		cards = new ArrayList<>();
		deliveryAddresses = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public UserEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserEntity setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserEntity setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public UserEntity setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public UserEntity setOrders(List<OrderEntity> orders) {
		this.orders = orders;
		return this;
	}

	public List<CreditCardEntity> getCards() {
		return cards;
	}

	public UserEntity setCards(List<CreditCardEntity> cards) {
		this.cards = cards;
		return this;
	}

	public List<AddressEntity> getDeliveryAddresses() {
		return deliveryAddresses;
	}

	public void setDeliveryAddresses(List<AddressEntity> deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}

}
