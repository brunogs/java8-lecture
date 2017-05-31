package br.com.blz.java8lecture.service;

import br.com.blz.java8lecture.domain.Cart;
import br.com.blz.java8lecture.domain.Customer;
import com.google.common.collect.Sets;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Optional;

import static com.github.npathai.hamcrestopt.OptionalMatchers.isEmpty;
import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresent;
import static java.util.Collections.emptySet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CartServiceTest {

    private CartService cartService;
    private Customer johnCustomer = new Customer("john");

    @Test
    public void should_not_found_cart() throws Exception {
        cartService = new CartService(emptySet());

        Optional<Cart> cartOne = cartService.getCartByCustomer(johnCustomer);
        assertThat(cartOne, isEmpty());

        Optional<Cart> cartTwo = cartService.getCartByCustomer(null);
        assertThat(cartTwo, isEmpty());
    }

    @Test
    public void should_found_cart_by_customer() throws Exception {
        cartService = new CartService(Sets.newHashSet(new Cart(johnCustomer)));

        Optional<Cart> cart = cartService.getCartByCustomer(johnCustomer);

        assertThat(cart, isPresent());
    }

    @Test
    public void should_create_a_new_cart() throws Exception {
        cartService = new CartService(emptySet());

        Cart cart = cartService.createCartToCustomer(johnCustomer);

        assertThat(cart, is(notNullValue()));
    }

    @Test
    public void should_retrieve_the_previous_created_cart() throws Exception {
        Cart previousCart = new Cart(johnCustomer);
        cartService = new CartService(Sets.newHashSet(previousCart));

        Cart cart = cartService.createCartToCustomer(johnCustomer);

        assertThat(cart, equalTo(previousCart));
    }
}