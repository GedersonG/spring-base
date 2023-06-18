package com.spring.baseproject.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductResponseDto {
    private Long idProduct;
    private String name;
    private String description;
    private int price;
    private int stock;
}
