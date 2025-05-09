package com.hoaiphong.microservice.order.service;

import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.hoaiphong.microservice.order.client.InventoryClient;
import com.hoaiphong.microservice.order.dto.order.OrderRequest;
import com.hoaiphong.microservice.order.event.OrderPlacedEvent;
import com.hoaiphong.microservice.order.model.Order;
import com.hoaiphong.microservice.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest) {
    
        // var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        // if (isProductInStock) {
            //map orderRequest to Order
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setQuantity(orderRequest.quantity());
            order.setSkuCode(orderRequest.skuCode());
            //save order
            orderRepository.save(order);

            //send messsage to kafka include order num and email
            OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent(order.getOrderNumber(), orderRequest.userDetails().email());
            log.info("Start- Sending OrderPlacedEvent {} to Kafka Topic", orderPlacedEvent);
            kafkaTemplate.send("order-placed", orderPlacedEvent);
            log.info("End- Sending OrderPlacedEvent {} to Kafka Topic", orderPlacedEvent);
        // }else {
        //     throw new RuntimeException("Product:" + orderRequest.skuCode() +"is not in stock");
        // }
        
        
    }

}
