package br.com.blz.java8lecture.service;

import br.com.blz.java8lecture.domain.Order;
import br.com.blz.java8lecture.domain.State;
import br.com.blz.java8lecture.memoizer.Memoizer;

import java.util.function.Function;
import java.util.stream.Stream;

import static br.com.blz.java8lecture.domain.State.SP;

public class FidelityService {

    public void evaluateFidelityForOrders(Stream<Order> orders) {

        // 1 -> Somente compras com destino fora de SP
        Stream<Order> ordersOutSP = orders.filter(this::isOutSP);

        // 2 -> Somente compras com valor acima de R$ 99

    }

    Boolean isOutSP(Order order) {

        Function<State, Boolean> isOutSP = state -> state != SP;

        Function<State, Boolean> isOutSPMemoized = Memoizer.memoize(isOutSP);

        return isOutSPMemoized.apply(order.getCustomer().getAddress().getState());
    }
}
