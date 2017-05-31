package br.com.blz.java8lecture.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

    private int id;

    private Customer customer;

    private Cart cart;
}
