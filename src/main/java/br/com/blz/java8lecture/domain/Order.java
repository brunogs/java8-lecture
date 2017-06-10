package br.com.blz.java8lecture.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = {"id", "customer"})
public class Order {

    private int id;

    private Customer customer;

    private Cart cart;

    private BigDecimal total;

    public Order(int id, Customer customer, Cart cart) {
        this.id = id;
        this.customer = customer;
        this.cart = cart;
    }

    public Order(int id, Customer customer, Cart cart, BigDecimal total) {
        this.id = id;
        this.customer = customer;
        this.cart = cart;
        this.cart.setTotal(total);
        this.total = total;
    }
}
