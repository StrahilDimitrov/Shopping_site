package com.example.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping.model.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
