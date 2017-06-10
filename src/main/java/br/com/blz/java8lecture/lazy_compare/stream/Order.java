package br.com.blz.java8lecture.lazy_compare.stream;


import java.util.Objects;

public class Order {
    int id;
    Customer customer;
    int total;

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.total = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
