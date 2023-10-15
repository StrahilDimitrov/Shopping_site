package com.example.shopping.model.entity;

import jakarta.persistence.*;

//TODO
public class CreditCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ownerName;

    @Column
    private String cardNumber;

    @Column
    private String code;

    @ManyToOne(targetEntity = UserEntity.class)
    private UserEntity user;

    public CreditCardEntity() {

    }

    public CreditCardEntity(String ownerName, String cardNumber, String code, UserEntity user) {
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
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

    public String getCardNumber() {
        return cardNumber;
    }

    public CreditCardEntity setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getCode() {
        return code;
    }

    public CreditCardEntity setCode(String code) {
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
