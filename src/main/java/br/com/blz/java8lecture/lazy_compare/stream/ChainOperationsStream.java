package br.com.blz.java8lecture.lazy_compare.stream;


import br.com.blz.java8lecture.dataset.OrderDatasets;
import br.com.blz.java8lecture.domain.Order;
import com.google.common.base.Stopwatch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ChainOperationsStream {

    public static void main(String[] args) {

        Set<Order> orders = new HashSet<>(OrderDatasets.orders(1_000_000));

        applyFilters(orders);

        System.out.println(".... ");

        applyFilters(orders);

        System.out.println(".... ");

        applyFilters(orders);

    }

    private static void applyFilters(Set<Order> orders) {
        Stopwatch stopwatch = Stopwatch.createStarted();

        boolean customerIsPresent = orders.stream()
                .filter(o -> o.getId() > 20)
                .filter(o -> o.getId() % 2 == 0)
                .map(Order::getCustomer)
                .filter(c -> c.getName() != null)
                .limit(50)
                .anyMatch(c -> c.getName().equals("customer30"));

        stopwatch.stop();

        System.out.println("is present: " + customerIsPresent);

        System.out.println("Java Stream Time ==> " + stopwatch);
    }
}
