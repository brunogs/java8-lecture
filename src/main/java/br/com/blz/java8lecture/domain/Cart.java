package br.com.blz.java8lecture.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.math.BigDecimal.ZERO;

public class Cart {

    private Customer customer;

    private Set<CartItem> items = new HashSet<>();

    private BigDecimal total = ZERO;

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public Optional<Customer> getCustomer() {
        return Optional.ofNullable(customer);
    }

    public Cart addItem(CartItem cartItem) {
        items.add(cartItem);
        return this;
    }

    public Optional<BigDecimal> getTotal() {
        return Optional.of(this.total);
    }

    public boolean contains(CartItem cartItem) {
        return items.contains(cartItem);
    }

    public Optional<CartItem> getItemBy(Product product) {
        return items.stream()
                .filter(item -> item.getProduct().equals(product))
                .findAny();
    }

    public boolean isFromCustomer(Customer customer) {
        return getCustomer()
                .filter(c -> c.equals(customer))
                .isPresent();
    }
}
