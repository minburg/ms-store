package com.example.store.repositories;

import com.example.store.domain.Product;
import com.example.store.domain.ProductColourEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByColour(ProductColourEnum color);

}
