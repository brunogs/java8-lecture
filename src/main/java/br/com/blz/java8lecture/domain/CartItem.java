package br.com.blz.java8lecture.domain;

public class CartItem {

    private Product product;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void increment() {
        quantity++;
    }
}
