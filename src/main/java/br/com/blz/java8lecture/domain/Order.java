package br.com.blz.java8lecture.domain;

import lombok.Data;

@Data
public class Order {

    private int id;

    private Customer customer;

    private Cart cart;

}
