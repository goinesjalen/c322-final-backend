package edu.iu.habahram.c322final.controllers;

import edu.iu.habahram.c322final.model.Order;
import edu.iu.habahram.c322final.repository.OrderFileRepository;
import edu.iu.habahram.c322final.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @PostMapping
    public int add(@RequestBody Order order) {
        orderRepository.save(order);
        return order.getId();
    }

    @GetMapping("/{id}")
    public List<Order> find(@PathVariable("id") int id) {
        List<Order> orders = (List<Order>) orderRepository.findAll();
        List<Order> matchingOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerId() == id) {
                matchingOrders.add(order);
            }
        }
        return matchingOrders;
    }

    @GetMapping
    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }



}