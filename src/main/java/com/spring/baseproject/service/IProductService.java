package com.spring.baseproject.service;

import com.spring.baseproject.dto.request.ProductRequestDto;
import com.spring.baseproject.dto.request.ProductUpdateRequestDto;
import com.spring.baseproject.dto.response.ProductResponseDto;

import java.util.List;

public interface IProductService {
    List<ProductResponseDto> getAllProducts();
    void saveProduct(ProductRequestDto requestDto);
    ProductResponseDto getProductById(Long id);
    void deleteProductById(Long id);
    void updateProductById(Long id, ProductUpdateRequestDto requestDto);
}
