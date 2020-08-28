package com.example.store.web.model;

import com.example.store.domain.ProductColourEnum;
import com.example.store.domain.ProductTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private UUID id;
    private String name;
    private Integer quantity;
    private Double price;
    private ProductTypeEnum type;
    private ProductColourEnum colour;

}

