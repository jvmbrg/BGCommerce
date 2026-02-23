package com.devbraga.bragacommerce.services;

import com.devbraga.bragacommerce.dto.OrderDTO;
import com.devbraga.bragacommerce.entities.Order;
import com.devbraga.bragacommerce.repository.OrderRepository;
import com.devbraga.bragacommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}
