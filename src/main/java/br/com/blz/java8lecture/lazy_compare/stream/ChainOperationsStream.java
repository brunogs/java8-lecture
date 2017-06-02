package br.com.blz.java8lecture.lazy_compare.stream;


import br.com.blz.java8lecture.domain.Order;
import com.google.common.base.Stopwatch;

import java.util.List;

public class ChainOperationsStream {

    public static void main(String[] args) {

        List<Order> orders = Datasets.orders(1_000_000);

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
