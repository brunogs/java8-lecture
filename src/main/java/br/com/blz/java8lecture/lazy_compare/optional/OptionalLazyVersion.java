package br.com.blz.java8lecture.lazy_compare.optional;


import br.com.blz.java8lecture.domain.Cart;
import br.com.blz.java8lecture.domain.Customer;
import br.com.blz.java8lecture.service.CartService;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Sets;

import static java.util.concurrent.TimeUnit.SECONDS;

public class OptionalLazyVersion {

    public static void main(String[] args) {
        Customer johnCustomer = new Customer("john");
        CartService cartService = new CartService(Sets.newHashSet(new Cart(johnCustomer)));

        Stopwatch stopwatch = Stopwatch.createStarted();

        Cart cart = cartService.getCartByCustomer(johnCustomer).orElseGet(() -> createCart(johnCustomer));

        stopwatch.stop();
        System.out.println("Eager Time ==> " + stopwatch);
    }

    private static Cart createCart(Customer customer) {
        try {
            SECONDS.sleep(5);
            return new Cart(customer);
        } catch (InterruptedException e) {
            return null;
        }
    }
}
