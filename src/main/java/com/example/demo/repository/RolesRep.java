package com.example.demo.repository;

import com.example.demo.entity.RolesEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RolesRep extends CrudRepository<RolesEntity, Long> {
  @Query(value = "SELECT r FROM roles r WHERE r.name = ?1", nativeQuery = true)
  RolesEntity findByName(String name);
}
