package br.com.blz.java8lecture.domain;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Cart {

    private Customer customer;

    private Set<CartItem> items = new HashSet<>();

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

    public boolean contains(CartItem cartItem) {
        return items.contains(cartItem);
    }

    public Optional<CartItem> getItemBy(Product product) {
        return items.stream()
                .filter(item -> item.getProduct().equals(product))
                .findAny();
    }
}
