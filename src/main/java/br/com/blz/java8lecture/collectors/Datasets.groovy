package br.com.blz.java8lecture.collectors

import br.com.blz.java8lecture.domain.Customer

class Datasets {

    static List<Customer> customers(long maxCustomers) {
        (1..maxCustomers).collect {
            new Customer("customer$it")
        }
    }
}
