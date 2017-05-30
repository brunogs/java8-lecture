package br.com.blz.java8lecture.service;

import br.com.blz.java8lecture.domain.Cart;
import br.com.blz.java8lecture.domain.CartItem;
import br.com.blz.java8lecture.domain.Customer;
import br.com.blz.java8lecture.domain.Product;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CartService {

    Set<Cart> cartsDataSet = new HashSet<>();

    public CartService(Set<Cart> cartsDataSet) {
        this.cartsDataSet = cartsDataSet;
    }

    public Optional<Cart> getCartByCustomer(Customer customer) {
        return cartsDataSet.stream()
                .filter(cart -> Optional.of(customer).equals(cart.getCustomer()))
                .findFirst();
    }

    public Cart createCartToCustomer(Customer customer) {
        return getCartByCustomer(customer).orElse(new Cart(customer));
    }

    public void addItemToCart(Customer customer, CartItem cartItem) {
        getCartByCustomer(customer)
                .map(cart -> cart.addItem(cartItem))
                .orElseThrow(IllegalStateException::new);
    }

    public boolean hasItemInCart(Customer customer, CartItem cartItem) {
        return getCartByCustomer(customer)
                .filter(cart -> cart.contains(cartItem))
                .isPresent();
    }

    public void incrementQuantity(Customer customer, Product product) {
        getCartByCustomer(customer)
                .flatMap(cart -> cart.getItemBy(product))
                .ifPresent(CartItem::increment);
    }

}
