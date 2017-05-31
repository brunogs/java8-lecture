package br.com.blz.java8lecture.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = "product")
@AllArgsConstructor
public class CartItem {

    private final Product product;
    private int quantity;

    public void increment() {
        quantity++;
    }
}
