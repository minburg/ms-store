package com.example.store.services.customer;

import com.example.store.domain.Product;
import com.example.store.domain.ProductColourEnum;
import com.example.store.domain.ProductTypeEnum;
import com.example.store.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import com.example.store.web.model.ProductDto;
import com.example.store.web.model.mapper.ProductMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    public List<ProductDto> getAllItemsWithMaxPrice(BigDecimal max) {
        return null;
    }

    @Override
    public List<ProductDto> getAllItems() {
        return productMapper.ListOfProductToListOfProductDto(productRepository.findAll());
    }

    @Override
    public ProductDto getItemById(UUID uuid) {
        return null;
    }

    private List<ProductDto> createProductsListToFillDatabase(){

        List<ProductDto> productList = new ArrayList<>();
        ProductDto product = ProductDto.builder()
                .name("Car")
                .colour(ProductColourEnum.BLACK)
                .quantity(1)
                .price(new BigDecimal(100))
                .type(ProductTypeEnum.LAPTOP)
                .build();

        ProductDto product2 = ProductDto.builder()
                .name("Car")
                .colour(ProductColourEnum.BLACK)
                .quantity(1)
                .price(new BigDecimal(100))
                .type(ProductTypeEnum.LAPTOP)
                .build();

        ProductDto product3 = ProductDto.builder()
                .name("Car")
                .colour(ProductColourEnum.BLACK)
                .quantity(1)
                .price(new BigDecimal(100))
                .type(ProductTypeEnum.LAPTOP)
                .build();

        ProductDto product4 = ProductDto.builder()
                .name("Car")
                .colour(ProductColourEnum.BLACK)
                .quantity(1)
                .price(new BigDecimal(100))
                .type(ProductTypeEnum.LAPTOP)
                .build();

        ProductDto product5 = ProductDto.builder()
                .name("Car")
                .colour(ProductColourEnum.BLACK)
                .quantity(1)
                .price(new BigDecimal(100))
                .type(ProductTypeEnum.LAPTOP)
                .build();

        ProductDto product6 = ProductDto.builder()
                .name("Car")
                .colour(ProductColourEnum.BLACK)
                .quantity(1)
                .price(new BigDecimal(100))
                .type(ProductTypeEnum.LAPTOP)
                .build();

        ProductDto product7 = ProductDto.builder()
                .name("Car")
                .colour(ProductColourEnum.BLACK)
                .quantity(1)
                .price(new BigDecimal(100))
                .type(ProductTypeEnum.LAPTOP)
                .build();

        ProductDto product8 = ProductDto.builder()
                .name("Car")
                .colour(ProductColourEnum.BLACK)
                .quantity(1)
                .price(new BigDecimal(100))
                .type(ProductTypeEnum.LAPTOP)
                .build();

        ProductDto product9 = ProductDto.builder()
                .name("Car")
                .colour(ProductColourEnum.BLACK)
                .quantity(1)
                .price(new BigDecimal(100))
                .type(ProductTypeEnum.LAPTOP)
                .build();


        ProductDto product10 = ProductDto.builder()
                .name("Car")
                .colour(ProductColourEnum.BLACK)
                .quantity(1)
                .price(new BigDecimal(100))
                .type(ProductTypeEnum.LAPTOP)
                .build();

        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);

        return productList;
    }

    @Override
    public void initializeDatabase() {
        List <ProductDto> products = createProductsListToFillDatabase();
        products.forEach(product -> {
            productRepository.saveAndFlush(productMapper.productDtoToProduct(product));
        });
    }
}
