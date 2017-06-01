package br.com.blz.java8lecture.service;

import br.com.blz.java8lecture.domain.Order;
import br.com.blz.java8lecture.domain.State;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.stream.Stream;

import static br.com.blz.java8lecture.domain.State.SP;
import static java.lang.Boolean.FALSE;

public class FidelityService implements Service {

    private static final BigDecimal FIDELITY_MINIMUM_TOTAL = new BigDecimal("99.00");

    public void evaluateFidelityForOrders(Stream<Order> orders) {

        // 1 -> Somente compras com destino fora de SP
        Stream<Order> ordersOutSP = orders.filter(this::isOutSP);

        // 2 -> Somente compras com valor acima de R$ 99
        Function<Order, Boolean> fnPrice = this::validateFidelityPrice;
        Stream<Order> ordersWithValidTotal = ordersOutSP.filter(fnPrice::apply);

        // 3 -> Data limite

    }

    Boolean isOutSP(Order order) {
        Function<State, Boolean> fnIsOutSPMemoized = memo(state -> state != SP);

        return fnIsOutSPMemoized.apply(order.getCustomer().getAddress().getState());
    }

    Boolean validateFidelityPrice(Order order) {

        Function<BigDecimal, Boolean> fnFidelityPrice = memo(total -> total.compareTo(FIDELITY_MINIMUM_TOTAL) > 0);

        if (order.getCart().getTotal().isPresent())
            return fnFidelityPrice.apply(order.getCart().getTotal().get());

        return FALSE;
    }
}
