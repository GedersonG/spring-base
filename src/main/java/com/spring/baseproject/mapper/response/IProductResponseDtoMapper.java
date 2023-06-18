package com.spring.baseproject.mapper.response;

import com.spring.baseproject.dto.response.ProductResponseDto;
import com.spring.baseproject.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IProductResponseDtoMapper {
    ProductResponseDto toResponse(ProductEntity productEntity);
    List<ProductResponseDto> toResponseList(List<ProductEntity> products);
}
