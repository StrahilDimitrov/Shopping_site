package com.example.shopping.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String country;

	@Column
	private String city;

	@Column
	private String address;

	@ManyToOne(targetEntity = UserEntity.class)
	private UserEntity user;

	public AddressEntity() {
	
	}

	public AddressEntity(String country, String city, String address, UserEntity user) {
		this.country = country;
		this.city = city;
		this.address = address;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public AddressEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public AddressEntity setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getCity() {
		return city;
	}

	public AddressEntity setCity(String city) {
		this.city = city;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public AddressEntity setAddress(String address) {
		this.address = address;
		return this;
	}

	public UserEntity getUser() {
		return user;
	}

	public AddressEntity setUser(UserEntity user) {
		this.user = user;
		return this;
	}

}
