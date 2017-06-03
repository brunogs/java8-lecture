package br.com.blz.java8lecture.domain;

import lombok.Data;

@Data
public class Customer {

    private String name;
    private Address address;
    private int age;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
