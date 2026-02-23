package com.devbraga.bragacommerce.repository;

import com.devbraga.bragacommerce.entities.OrderItem;
import com.devbraga.bragacommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
