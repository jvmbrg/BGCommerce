package com.devbraga.bragacommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {
    private Integer quantity;
    private Double price;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    public OrderItem(){}

    public OrderItem(Order order, Product product, Double price, Integer quantity) {
        id.setProduct(product);
        id.setOrder(order);
        this.price = price;
        this.quantity = quantity;
    }


    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
