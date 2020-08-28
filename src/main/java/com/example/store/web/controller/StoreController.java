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

    @GetMapping("/items/filter/maxPrice/{price}")
    public ResponseEntity<List<ProductDto>> getAllItemsWithMaxPrice(@PathVariable("price") BigDecimal maxPrice){
        return new ResponseEntity<>(customerService.getAllItemsWithMaxPrice(maxPrice), HttpStatus.OK);
    }

    @GetMapping("/items/filter/color/{color}")
    public ResponseEntity<List<ProductDto>> getallItemsWithColor(@PathVariable("color") String color){
        return new ResponseEntity<>(customerService.getAllItemsWithColor(color), HttpStatus.OK);
    }

    @GetMapping("/items/getItem/{id}")
    public ResponseEntity<ProductDto> getItemById(@PathVariable("id") UUID uuid) throws Exception {
        return new ResponseEntity<>(customerService.getItemById(uuid), HttpStatus.OK);
    }

    @GetMapping("/items/isAvailable/{id}")
    public ResponseEntity<Boolean> isAvailable(@PathVariable("id") UUID uuid) throws Exception {
        return new ResponseEntity<>(customerService.isAvailable(uuid), HttpStatus.OK);
    }

    @PostMapping("/initialize")
    public ResponseEntity createProduct(){
        customerService.initializeDatabase();
        return new ResponseEntity(HttpStatus.OK);
    }




}
