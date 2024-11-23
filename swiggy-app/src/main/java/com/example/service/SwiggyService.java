package com.example.service;


import com.example.client.RestaurentServiceClient;
import com.example.dto.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SwiggyService {

    @Autowired
    private RestaurentServiceClient restaurentServicClient;

    public OrderResponseDTO checkOrderStatus(String orderId) {

       return restaurentServicClient.fetchOrderStatus(orderId);
    }
}
