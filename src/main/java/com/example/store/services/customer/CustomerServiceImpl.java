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
    public ProductDto getItemById(UUID uuid) throws Exception {
        return productMapper.productToProductDto(productRepository.findById(uuid).orElseThrow( () -> new Exception()));
    }

    @Override
    public Boolean isAvailable(UUID uuid) throws Exception {
        Product product = productRepository.findById(uuid).orElseThrow( () -> new Exception());
        if(product.getQuantity()>0){
            return true;
        }else{
            return false;
        }
    }

    private List<ProductDto> createProductsListToFillDatabase(){

        List<ProductDto> productList = new ArrayList<>();
        ProductDto product = ProductDto.builder()
                .name("Sony Gaming Laptop 3000")
                .colour(ProductColourEnum.BLUE)
                .quantity(7)
                .price(new BigDecimal(1600))
                .type(ProductTypeEnum.LAPTOP)
                .build();

        ProductDto product2 = ProductDto.builder()
                .name("MacBook Pro 16")
                .colour(ProductColourEnum.BLACK)
                .quantity(3)
                .price(new BigDecimal(2300))
                .type(ProductTypeEnum.LAPTOP)
                .build();

        ProductDto product3 = ProductDto.builder()
                .name("Lenovo Yoga 3")
                .colour(ProductColourEnum.GREEN)
                .quantity(5)
                .price(new BigDecimal(500))
                .type(ProductTypeEnum.LAPTOP)
                .build();

        ProductDto product4 = ProductDto.builder()
                .name("Playstation 5")
                .colour(ProductColourEnum.BLACK)
                .quantity(10)
                .price(new BigDecimal(600))
                .type(ProductTypeEnum.PLAYSTATION)
                .build();

        ProductDto product5 = ProductDto.builder()
                .name("Playstation 5")
                .colour(ProductColourEnum.GREEN)
                .quantity(8)
                .price(new BigDecimal(600))
                .type(ProductTypeEnum.PLAYSTATION)
                .build();

        ProductDto product6 = ProductDto.builder()
                .name("Playstation 4 Pro")
                .colour(ProductColourEnum.BLACK)
                .quantity(30)
                .price(new BigDecimal(400))
                .type(ProductTypeEnum.PLAYSTATION)
                .build();

        ProductDto product7 = ProductDto.builder()
                .name("Playstation 4 Pro")
                .colour(ProductColourEnum.GREEN)
                .quantity(30)
                .price(new BigDecimal(400))
                .type(ProductTypeEnum.PLAYSTATION)
                .build();

        ProductDto product8 = ProductDto.builder()
                .name("Playstation 4 slim")
                .colour(ProductColourEnum.BLACK)
                .quantity(50)
                .price(new BigDecimal(250))
                .type(ProductTypeEnum.PLAYSTATION)
                .build();

        ProductDto product9 = ProductDto.builder()
                .name("Playstation 4 slim")
                .colour(ProductColourEnum.WHITE)
                .quantity(37)
                .price(new BigDecimal(250))
                .type(ProductTypeEnum.PLAYSTATION)
                .build();


        ProductDto product10 = ProductDto.builder()
                .name("Sony ag9")
                .colour(ProductColourEnum.BLACK)
                .quantity(15)
                .price(new BigDecimal(1800))
                .type(ProductTypeEnum.TV)
                .build();

        ProductDto product11 = ProductDto.builder()
                .name("Sony ag8")
                .colour(ProductColourEnum.BLACK)
                .quantity(25)
                .price(new BigDecimal(1500))
                .type(ProductTypeEnum.TV)
                .build();

        ProductDto product12 = ProductDto.builder()
                .name("LG C9")
                .colour(ProductColourEnum.WHITE)
                .quantity(40)
                .price(new BigDecimal(1700))
                .type(ProductTypeEnum.TV)
                .build();

        ProductDto product13 = ProductDto.builder()
                .name("Xbox Series X")
                .colour(ProductColourEnum.BLACK)
                .quantity(13)
                .price(new BigDecimal(600))
                .type(ProductTypeEnum.XBOX)
                .build();

        ProductDto product14 = ProductDto.builder()
                .name("XBox One X")
                .colour(ProductColourEnum.WHITE)
                .quantity(22)
                .price(new BigDecimal(340))
                .type(ProductTypeEnum.XBOX)
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
        productList.add(product11);
        productList.add(product12);
        productList.add(product13);
        productList.add(product14);

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
