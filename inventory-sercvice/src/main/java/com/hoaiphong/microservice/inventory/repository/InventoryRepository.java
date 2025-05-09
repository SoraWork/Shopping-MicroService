package com.hoaiphong.microservice.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoaiphong.microservice.inventory.model.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode, int quantity);

}
