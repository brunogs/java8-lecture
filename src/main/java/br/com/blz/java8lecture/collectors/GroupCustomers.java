package br.com.blz.java8lecture.collectors;

import br.com.blz.java8lecture.dataset.OrderDatasets;
import br.com.blz.java8lecture.domain.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ZERO;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

public class GroupCustomers {

    public static void main(String[] args) {

        List<Order> orders = OrderDatasets.orders(500);

        Function<Order, String> orderByCustomer = o -> o.getCustomer().getName();

        Map<String, Long> countOrderByCustomer = orders.stream()
                .collect(groupingBy(
                        orderByCustomer,
                        counting())
                );

        Map<String, BigDecimal> totalOrdersByCustomer = orders.stream()
                .collect(groupingBy(
                                orderByCustomer,
                                mapping(Order::getTotal, reducing(ZERO, BigDecimal::add))
                        )
                );

        countOrderByCustomer.forEach( (customer, countOrder) ->
            System.out.println(String.format("Customer: %s, number of orders: %d", customer, countOrder))
        );

        System.out.println("\n\n\n");

        totalOrdersByCustomer.forEach( (customer, total) ->
                System.out.println(String.format("Customer: %s, total: %s", customer, total))
        );

    }

}
