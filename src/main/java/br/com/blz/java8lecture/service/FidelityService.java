package br.com.blz.java8lecture.service;

import br.com.blz.java8lecture.domain.Order;
import br.com.blz.java8lecture.domain.State;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static br.com.blz.java8lecture.domain.State.SP;
import static br.com.blz.java8lecture.memoizer.Memoizer.memoize;
import static java.lang.Boolean.FALSE;

public class FidelityService implements Service {

    private static final BigDecimal FIDELITY_MINIMUM_TOTAL = new BigDecimal("99.00");

    public static boolean isDifal(Stream<Order> orders) {

        // 1 -> Somente compras com destino fora de SP
        Stream<Order> ordersOutSP = orders.filter(FidelityService::isOutSP);

        // 2 -> Somente compras com valor acima de R$ 99
        Predicate<Order> fnPrice = FidelityService::validateFidelityPrice;

        Stream<Order> ordersWithValidTotal = ordersOutSP.filter(fnPrice);

        return ordersWithValidTotal.count() > 0;
    }
    static Boolean isOutSP(Order order) {
        Function<State, Boolean> fnIsOutSPMemoized = memoize(state -> state != SP);

        return fnIsOutSPMemoized.apply(order.getCustomer().getAddress().getState());
    }

    static Boolean validateFidelityPrice(Order order) {

        Function<BigDecimal, Boolean> fnFidelityPrice = memoize(total -> total.compareTo(FIDELITY_MINIMUM_TOTAL) > 0);

        return order.getCart().getTotal()
                .map(fnFidelityPrice)
                .orElse(FALSE);
    }
}
