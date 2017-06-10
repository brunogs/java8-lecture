package br.com.blz.java8lecture.lazy_compare.stream;


import com.google.common.base.Stopwatch;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class ChainOperationsStream {

    static List<Order> orders(int maxOrders) {
        Random random = new Random();
        return range(1, maxOrders).boxed()
                .map(orderId -> {
                    int customerId = random.nextInt(50) + 1;
                    Customer customer = new Customer("customer" + customerId);
                    return new Order(orderId, customer);
                }).collect(toList());

    }

    public static void main(String[] args) {

        List<Order> orders = orders(1_000_000);

        for (int i = 0; i < 5; i++) {
            System.out.println("\n\nFilters batch " + i);

            applyFilters(orders);

            System.out.println(".... ");

            applyFilters(orders);

            System.out.println(".... ");

            applyFilters(orders);

        }

    }

    private static void applyFilters(Collection<Order> orders) {
        Stopwatch stopwatch = Stopwatch.createStarted();

        boolean customerIsPresent = orders.stream()
                .filter(o -> o.id > 20)
                .filter(o -> o.id % 2 == 0)
                .map(o -> o.customer)
                .filter(c -> c.name != null)
                .limit(50)
                .anyMatch(c -> c.name.equals("customer30"));

        stopwatch.stop();

        System.out.println("is present: " + customerIsPresent);

        System.out.println("Java Stream Time ==> " + stopwatch);
    }
}
