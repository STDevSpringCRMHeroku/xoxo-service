package com.froyo.jpa.postgres.repository;

import com.froyo.jpa.postgres.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByEancode(String eancode);
}
