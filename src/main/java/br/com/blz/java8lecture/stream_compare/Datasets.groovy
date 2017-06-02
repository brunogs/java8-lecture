package br.com.blz.java8lecture.stream_compare

import br.com.blz.java8lecture.domain.Cart
import br.com.blz.java8lecture.domain.Customer
import br.com.blz.java8lecture.domain.Order


class Datasets {

    static List<Order> orders(long maxOrders = 1000) {
        (1..maxOrders).collect {
            Customer customer = new Customer("customer$it")
            Cart cart = new Cart(customer)
            new Order(id: it, customer: customer, cart: cart)
        }
    }
}
