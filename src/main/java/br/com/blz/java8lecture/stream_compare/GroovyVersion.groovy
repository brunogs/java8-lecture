package br.com.blz.java8lecture.stream_compare

import br.com.blz.java8lecture.domain.Order
import com.google.common.base.Stopwatch


class GroovyVersion {

    static void main(String[] args) {
        List<Order> orders = Datasets.orders(1_000_000)

        Stopwatch stopwatch = Stopwatch.createStarted()

        boolean customerIsPresent = orders
                .findAll { it.id > 20 }
                .collect { it.customer }
                .findAll { it.name }
                .take(500)
                .any { it.name == "customer30" }

        stopwatch.stop()

        System.out.println("numero de pedidos: $customerIsPresent")

        System.out.println("Groovy Time ==> " + stopwatch)
    }

}
