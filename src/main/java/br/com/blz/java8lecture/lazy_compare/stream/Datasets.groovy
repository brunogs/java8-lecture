package br.com.blz.java8lecture.lazy_compare.stream

import br.com.blz.java8lecture.domain.Cart
import br.com.blz.java8lecture.domain.Customer
import br.com.blz.java8lecture.domain.Order

class Datasets {

    static List<Order> orders(long maxOrders) {
        (1..maxOrders).collect {
            Customer customer = new Customer("customer$it", null)
            Cart cart = new Cart(customer)
            new Order(it.intValue(), customer, cart)
        }
    }
}
