package br.com.blz.java8lecture.lazy_compare.stream

import br.com.blz.java8lecture.dataset.OrderDatasets
import br.com.blz.java8lecture.domain.Order
import com.google.common.base.Stopwatch

class SimpleFilterGroovy {

    static void main(String[] args) {

        List<Order> orders = OrderDatasets.orders(500_000)

        Stopwatch stopwatch = Stopwatch.createStarted()

        long count = orders.count { it.id % 2 == 0 }

        stopwatch.stop()

        System.out.println("count: $count")

        System.out.println("Groovy Time ==> " + stopwatch)

    }
}
