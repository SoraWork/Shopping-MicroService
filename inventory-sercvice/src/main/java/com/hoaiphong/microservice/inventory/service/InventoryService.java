package com.hoaiphong.microservice.inventory.service;

import org.springframework.stereotype.Service;

import com.hoaiphong.microservice.inventory.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, int quantity) {
       //Find the inventory record for the given skuCode where quantity is greater than 0
       return inventoryRepository.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode, quantity);
    }

}
