package com.hoaiphong.microservice.product.dto.product;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, String description, BigDecimal price) {

}
