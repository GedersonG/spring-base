package com.spring.baseproject.dao;

import com.spring.baseproject.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
    boolean existsByName(String name);

    @Modifying
    @Query("UPDATE ProductEntity p SET " +
           "p.name = COALESCE(:#{#productDto.name}, p.name), " +
           "p.description = COALESCE(:#{#productDto.description}, p.description), " +
           "p.price = COALESCE(:#{#productDto.price}, p.price), " +
           "p.stock = COALESCE(:#{#productDto.stock}, p.stock) " +
           "WHERE p.idProduct = :#{#productDto.idProduct}"
    )
    void updateProduct(@Param("productDto") ProductEntity product);
}
