package com.spring.baseproject.configuration;

import com.spring.baseproject.dao.IProductRepository;
import com.spring.baseproject.mapper.request.IProductRequestDtoMapper;
import com.spring.baseproject.mapper.response.IProductResponseDtoMapper;
import com.spring.baseproject.service.IProductService;
import com.spring.baseproject.serviceImpl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
@RequiredArgsConstructor
public class ProductBeanConfiguration {

    private final IProductRepository productRepository;
    private final IProductResponseDtoMapper productResponseDtoMapper;
    private final IProductRequestDtoMapper productRequestDtoMapper;

    @Bean
    public IProductService productService() {
        return new ProductService(
                productRepository,
                productRequestDtoMapper,
                productResponseDtoMapper
        );
    }
}
