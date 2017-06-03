package br.com.blz.java8lecture.collectors;

import br.com.blz.java8lecture.dataset.OrderDatasets;
import br.com.blz.java8lecture.domain.Order;

import java.math.BigDecimal;
import java.util.List;

public class OrdersReduce {

    public static void main(String[] args) {

        List<Order> ordersFromCustomer = OrderDatasets.ordersWithTotal(500, 10);

        ordersFromCustomer.stream()
                .map(Order::getTotal)
                .reduce(BigDecimal::add)
                .ifPresent(ordersSum ->
                    System.out.println("final sum: " + ordersSum)
                );
    }

}
