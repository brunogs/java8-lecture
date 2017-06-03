package br.com.blz.java8lecture.lazy_compare.stream;

import br.com.blz.java8lecture.dataset.OrderDatasets;
import br.com.blz.java8lecture.domain.Order;
import com.google.common.base.Stopwatch;

import java.util.List;

public class SimpleFilterStream {

    public static void main(String[] args) {
        List<Order> orders = OrderDatasets.orders(500_000);

        Stopwatch stopwatch = Stopwatch.createStarted();


        long count = orders.stream()
                .filter(o -> o.getId() % 2 == 0)
                .count();

        stopwatch.stop();

        System.out.println("count : " + count);

        System.out.println("Java Stream Time ==> " + stopwatch);
    }
}
