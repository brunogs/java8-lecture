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
                new Order(new Customer("Natan Deitch", new Address(RS)), null),
                new Order(new Customer("Natan Deitch", new Address(RS)), null),
                new Order(new Customer("Natan Deitch", new Address(RS)), null),
                new Order(new Customer("Natan Deitch", new Address(RS)), null),
                new Order(new Customer("Natan Deitch", new Address(RS)), null),
                new Order(new Customer("Bruno Gomes", new Address(SP)), null),
                new Order(new Customer("Bruno Gomes", new Address(SP)), null),
                new Order(new Customer("Bruno Gomes", new Address(SP)), null),
                new Order(new Customer("Bruno Gomes", new Address(SP)), null),
                new Order(new Customer("Bruno Gomes", new Address(SP)), null));

        FidelityService fidelityService = new FidelityService();

        Stream<Order> ordersOutSP = orderStream.filter(fidelityService::isOutSP);

        Assert.assertEquals(5, ordersOutSP.count());
    }
}