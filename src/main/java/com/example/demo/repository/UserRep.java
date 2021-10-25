package com.example.demo.repository;

import com.example.demo.entity.UserEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserRep extends CrudRepository<UserEntity, Long> {
  UserEntity findByUsername(String username);

}
