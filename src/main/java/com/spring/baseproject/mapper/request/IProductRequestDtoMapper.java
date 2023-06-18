package com.spring.baseproject.mapper.request;

import com.spring.baseproject.dto.request.ProductRequestDto;
import com.spring.baseproject.dto.request.ProductUpdateRequestDto;
import com.spring.baseproject.entity.ProductEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IProductRequestDtoMapper {
    ProductEntity toEntity(ProductRequestDto requestDto);

    @Mapping(target = "idProduct", expression = "java(id)")
    ProductEntity dtoUpdateToEntity(ProductUpdateRequestDto requestDto, @Context Long id);
}
