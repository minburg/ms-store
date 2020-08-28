package com.example.store.web.controller;

import com.example.store.domain.ProductColourEnum;
import com.example.store.services.customer.CustomerService;
import com.example.store.web.model.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/store")
@RestController
public class StoreController {

    private CustomerService customerService;

    public StoreController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PutMapping("/orderItem")
    public ResponseEntity placeOrder(@RequestBody List<UUID> uuids){
        customerService.placeOrder(uuids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allItems")
    public ResponseEntity<List<ProductDto>> getAllItems(){
        return new ResponseEntity<>(customerService.getAllItems(), HttpStatus.OK);
    }

    @GetMapping("/Items/filter/MaxPrice/{price}")
    public ResponseEntity<List<ProductDto>> getAllItemsWithMaxPrice(@PathVariable("price") BigDecimal maxPrice){
        return new ResponseEntity<>(customerService.getAllItemsWithMaxPrice(maxPrice), HttpStatus.OK);
    }

    @GetMapping("/Items/filter/color/{color}")
    public ResponseEntity<List<ProductDto>> getallItemsWithColor(@PathVariable("color") ProductColourEnum color){
        return new ResponseEntity<>(customerService.getAllItemsWithColor(color), HttpStatus.OK);
    }

    @GetMapping("/Items/isAvailable/{id}")
    public ResponseEntity<ProductDto> getItemById(@PathVariable("id") UUID uuid){
        return new ResponseEntity<>(customerService.getItemById(uuid), HttpStatus.OK);
    }

    @GetMapping("/createProduct")
    public ResponseEntity<ProductDto> createProduct(){
        return new ResponseEntity<>(customerService.createProduct(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ProductDto> creatfeeProduct(){
        return new ResponseEntity<>(customerService.createProduct(), HttpStatus.OK);
    }



}
