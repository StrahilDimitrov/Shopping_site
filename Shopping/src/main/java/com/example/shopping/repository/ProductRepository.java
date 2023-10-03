package com.example.shopping.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.shopping.model.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	@Query("SELECT p FROM ProductEntity p WHERE p.productName LIKE %:filter%")
	Optional<List<ProductEntity>> search(String filter);

}
