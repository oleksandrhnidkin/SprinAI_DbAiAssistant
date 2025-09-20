package com.example.demo.testai;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderManagementService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Long createOrder(OrderInfo orderInfo) {

        System.out.println(orderInfo.getOrderID());
        System.out.println(orderInfo.getUserID());
        System.out.println(orderInfo.getOrderQuantity());

        System.out.println(orderRepository.findAll());

        return orderRepository.save(orderInfo).getOrderID();
    }

    public Optional<List<OrderInfo>> getAllUserOrders(String userID) {
        return orderRepository.findByUserID(userID);
    }
}
