package br.com.blz.java8lecture.dataset

import br.com.blz.java8lecture.domain.Address
import br.com.blz.java8lecture.domain.Cart
import br.com.blz.java8lecture.domain.Customer
import br.com.blz.java8lecture.domain.Order
import br.com.blz.java8lecture.domain.State

import static br.com.blz.java8lecture.domain.State.RS
import static br.com.blz.java8lecture.domain.State.SP

class OrderDatasets {

    static List<Order> orders(long maxOrders) {
        Random random = new Random()
        (1..maxOrders).collect {
            int customerId = random.nextInt(50) + 1
            Customer customer
            if (it % 2 == 0)
                customer = new Customer("customer$customerId", new Address(RS))
            else
                customer = new Customer("customer$customerId", new Address(SP))
            Cart cart = new Cart(customer)
            new Order(it.intValue(), customer, cart, BigDecimal.valueOf(it))
        }
    }

    static List<Order> ordersWithTotal(long maxOrders, int customerId) {
        Customer customer = new Customer("customer$customerId", new Address(State.AC))
        Random random = new Random()
        (1..maxOrders).collect {
            Cart cart = new Cart(customer)
            int randomValue = random.nextInt(300) + 1
            new Order(it.intValue(), customer, cart, BigDecimal.valueOf(randomValue))
        }
    }
}
