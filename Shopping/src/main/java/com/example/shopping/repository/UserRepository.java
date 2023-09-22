package com.example.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
