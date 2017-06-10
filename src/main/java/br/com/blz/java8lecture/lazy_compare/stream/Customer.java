package br.com.blz.java8lecture.lazy_compare.stream;

import java.util.Objects;

public class Customer {
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Customer(String name) {
        this.name = name;
    }

}
