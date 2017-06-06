package br.com.blz.java8lecture.collectors;

import br.com.blz.java8lecture.dataset.OrderDatasets;
import br.com.blz.java8lecture.domain.Order;

import java.util.List;

import static br.com.blz.java8lecture.collectors.DifalCollector.toDifal;

public class CustomCollector {

    public static void main(String[] args) {
        List<Order> orders = OrderDatasets.orders(150).stream().collect(toDifal());

        orders.forEach(order -> System.out.printf("Order State: %s\nOrder Total: %s", order.getCustomer().getAddress().getState(), order.getCart().getTotal()));
    }
}
