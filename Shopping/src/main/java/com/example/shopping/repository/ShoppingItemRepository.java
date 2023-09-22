package com.example.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping.model.entity.ShoppingItemEntity;

public interface ShoppingItemRepository extends JpaRepository<ShoppingItemEntity, Long> {

}