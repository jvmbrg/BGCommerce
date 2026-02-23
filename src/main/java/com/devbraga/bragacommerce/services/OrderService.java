package com.devbraga.bragacommerce.services;

import com.devbraga.bragacommerce.dto.OrderDTO;
import com.devbraga.bragacommerce.dto.OrderItemDTO;
import com.devbraga.bragacommerce.entities.Order;
import com.devbraga.bragacommerce.entities.OrderItem;
import com.devbraga.bragacommerce.entities.Product;
import com.devbraga.bragacommerce.entities.User;
import com.devbraga.bragacommerce.enums.OrderStatus;
import com.devbraga.bragacommerce.repository.OrderItemRepository;
import com.devbraga.bragacommerce.repository.OrderRepository;
import com.devbraga.bragacommerce.repository.ProductRepository;
import com.devbraga.bragacommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        authService.validateSelOrAdmin(order.getClient().getId());
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        for(OrderItemDTO itemDTO : dto.getItems()){
            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem item = new OrderItem(order, product, product.getPrice(), itemDTO.getQuantity());
            order.getItems().add(item);
        }

        orderRepository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
