package com.spring.baseproject.serviceImpl;

import com.spring.baseproject.dao.IProductRepository;
import com.spring.baseproject.dto.request.ProductRequestDto;
import com.spring.baseproject.dto.request.ProductUpdateRequestDto;
import com.spring.baseproject.dto.response.ProductResponseDto;
import com.spring.baseproject.entity.ProductEntity;
import com.spring.baseproject.exception.AlreadyExistsException;
import com.spring.baseproject.exception.NoDataFoundException;
import com.spring.baseproject.mapper.request.IProductRequestDtoMapper;
import com.spring.baseproject.mapper.response.IProductResponseDtoMapper;
import com.spring.baseproject.service.IProductService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Resource
    private IProductRequestDtoMapper productRequestDtoMapper;

    @Resource
    private IProductResponseDtoMapper productResponseDtoMapper;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        if (products.isEmpty())
            throw new NoDataFoundException();
        return productResponseDtoMapper.toResponseList(products);
    }

    @Override
    public void saveProduct(ProductRequestDto productRequestDto) {
        existsByName(productRequestDto.getName());
        if (productRequestDto.getDescription() == null)
            productRequestDto.setDescription("");

        productRepository.save(productRequestDtoMapper.toEntity(productRequestDto));
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        ProductEntity product = productRepository.findById(id).orElseThrow(AlreadyExistsException::new);

        return productResponseDtoMapper.toResponse(product);
    }

    @Override
    public void deleteProductById(Long id) {
        existsById(id);

        productRepository.deleteById(id);
    }

    @Override
    public void updateProductById(Long id, ProductUpdateRequestDto productUpdateRequestDto) {
        ProductEntity product =
                productRepository.
                findById(id).
                orElseThrow(NoDataFoundException::new);

        if (!product.getName().equals(productUpdateRequestDto.getName())) {
            existsByName(productUpdateRequestDto.getName());
        }

        if (productUpdateRequestDto.getDescription() == null)
            productUpdateRequestDto.setDescription("");

        ProductEntity updatedProduct = productRequestDtoMapper.dtoUpdateToEntity(productUpdateRequestDto, id);
        productRepository.updateProduct(updatedProduct);
    }

    private void existsById(Long id) {
        if (!productRepository.existsById(id))
            throw new NoDataFoundException();
    }

    private void existsByName(String name) {
        if (productRepository.existsByName(name))
            throw new AlreadyExistsException();
    }
}
