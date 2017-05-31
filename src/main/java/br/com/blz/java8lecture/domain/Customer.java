package br.com.blz.java8lecture.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private String name;
    private Address address;
}
