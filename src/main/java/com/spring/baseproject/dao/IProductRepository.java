package com.spring.baseproject.dao;

import com.spring.baseproject.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Long, ProductEntity> {
}
