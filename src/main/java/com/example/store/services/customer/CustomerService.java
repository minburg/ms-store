package com.example.store.services.customer;

import com.example.store.domain.ProductColourEnum;
import com.example.store.web.model.ProductDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Created by Marinus on 27/08/2020 inside package: com.example.store.services.customer
 */
public interface CustomerService {

    void placeOrder(List<UUID> uuids);

    List<ProductDto> getAllItemsWithColor(ProductColourEnum color);

    List<ProductDto> getAllItemsWithMaxPrice(BigDecimal max);

    List<ProductDto> getAllItems();

    ProductDto getItemById(UUID uuid);

    void initializeDatabase();
}
