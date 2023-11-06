package com.vinicius.springudemy.entities.pk;

import com.vinicius.springudemy.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

import com.vinicius.springudemy.entities.Order;
//classe auxiliar
@Embeddable
public class OrderItemPk implements Serializable{
    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof OrderItemPk))
            return false;
        OrderItemPk other = (OrderItemPk) obj;
        return Objects.equals(order, other.order) && Objects.equals(product, other.product);
    }   
}
