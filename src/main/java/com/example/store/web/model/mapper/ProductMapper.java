package com.example.store.web.model.mapper;

import com.example.store.domain.Product;
import org.mapstruct.Mapper;
import com.example.store.web.model.ProductDto;

/**
 * Created by Marinus on 27/08/2020 inside package: web.model.mapper
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto productToProductDto(Product product);
}
