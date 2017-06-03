package br.com.blz.java8lecture.service;

import br.com.blz.java8lecture.domain.Address;
import br.com.blz.java8lecture.domain.Customer;
import br.com.blz.java8lecture.domain.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

import static br.com.blz.java8lecture.domain.State.RS;
import static br.com.blz.java8lecture.domain.State.SP;

public class FidelityServiceTest {

    @Test
    public void should() {
        Stream<Order> orderStream = Stream.of(
                new Order(1, new Customer("Natan Deitch", new Address(RS)), null),
                new Order(2, new Customer("Natan Deitch", new Address(RS)), null),
                new Order(3, new Customer("Natan Deitch", new Address(RS)), null),
                new Order(4, new Customer("Natan Deitch", new Address(RS)), null),
                new Order(5, new Customer("Natan Deitch", new Address(RS)), null),
                new Order(6, new Customer("Bruno Gomes", new Address(SP)), null),
                new Order(7, new Customer("Bruno Gomes", new Address(SP)), null),
                new Order(8, new Customer("Bruno Gomes", new Address(SP)), null),
                new Order(9, new Customer("Bruno Gomes", new Address(SP)), null),
                new Order(10, new Customer("Bruno Gomes", new Address(SP)), null));

        FidelityService fidelityService = new FidelityService();

        Stream<Order> ordersOutSP = orderStream.filter(fidelityService::isOutSP);

        Assert.assertEquals(5, ordersOutSP.count());
    }
}