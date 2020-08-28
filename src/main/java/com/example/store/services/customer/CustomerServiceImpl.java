package com.example.store.services.customer;

import com.example.store.domain.Product;
import com.example.store.domain.ProductColourEnum;
import com.example.store.domain.ProductTypeEnum;
import com.example.store.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import com.example.store.web.model.ProductDto;
import com.example.store.web.model.mapper.ProductMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Created by Marinus on 27/08/2020 inside package: com.example.store.services.customer
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public CustomerServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public void placeOrder(List<UUID> uuids) {

    }

    @Override
    public List<ProductDto> getAllItemsWithColor(ProductColourEnum color) {
        return null;
    }

    @Override
    public List<ProductDto> getGreenProducts() {
        return null;
    }

    @Override
    public List<ProductDto> getAllItemsWithMaxPrice(BigDecimal max) {
        return null;
    }

    @Override
    public List<ProductDto> getAllItems() {
        return null;
    }

    @Override
    public ProductDto getItemById(UUID uuid) {
        return null;
    }

    @Override
    public ProductDto createProduct() {
        Product product = Product.builder()
                .name("Car")
                .colour(ProductColourEnum.BLACK)
                .quantity(1)
                .price(new BigDecimal(100))
                .type(ProductTypeEnum.LAPTOP)
                .build();


        productMapper.productToProductDto(product);
        Product product1 = productRepository.saveAndFlush(product);
        return productMapper.productToProductDto(product1);
    }
}
