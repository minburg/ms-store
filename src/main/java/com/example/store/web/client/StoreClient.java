package com.example.store.web.client;

import com.example.store.web.model.ProductDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.store", ignoreUnknownFields = false)
public class StoreClient {

    public final String WAREHOUSE_PATH_V1 = "api/v1/warehouse/";
    private String apihost;
    private final RestTemplate restTemplate;

    public StoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ProductDto restockFromWarehouse(UUID uuid){
        return restTemplate.getForObject(apihost + WAREHOUSE_PATH_V1, ProductDto.class, uuid);
    }



    public void setApihost(String apihost){
        this.apihost = apihost;
    }
}
