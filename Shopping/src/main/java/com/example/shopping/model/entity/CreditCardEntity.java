package com.example.shopping.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "credit_cards")
public class CreditCardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String ownerName;

	@Column
	private String number;

	@Column
	private Integer code;

	@ManyToOne(targetEntity = UserEntity.class)
	private UserEntity user;

	public CreditCardEntity() {

	}

	public CreditCardEntity(String ownerName, String number, Integer code, UserEntity user) {
		this.ownerName = ownerName;
		this.number = number;
		this.code = code;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public CreditCardEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public CreditCardEntity setOwnerName(String ownerName) {
		this.ownerName = ownerName;
		return this;
	}

	public String getNumber() {
		return number;
	}

	public CreditCardEntity setNumber(String number) {
		this.number = number;
		return this;
	}

	public Integer getCode() {
		return code;
	}

	public CreditCardEntity setCode(Integer code) {
		this.code = code;
		return this;
	}

	public UserEntity getUser() {
		return user;
	}

	public CreditCardEntity setUser(UserEntity user) {
		this.user = user;
		return this;
	}

}
