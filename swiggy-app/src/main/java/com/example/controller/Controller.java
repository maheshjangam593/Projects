package com.example.controller;

import com.example.dto.OrderResponseDTO;
import com.example.service.SwiggyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swiggy")
public class Controller {

    @Autowired
    private SwiggyService swiggyService;

    @GetMapping("/{orderId}")
    public OrderResponseDTO checkOrderStatus(@PathVariable String orderId) {
        return swiggyService.checkOrderStatus(orderId);
    }

}
