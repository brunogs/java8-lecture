package br.com.blz.java8lecture.collectors;

import java.util.*;

import static java.lang.Long.MAX_VALUE;
import static java.util.Comparator.naturalOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

//TODO median
public class BlzStatsSummary extends DoubleSummaryStatistics {

    private List<Double> counter = new ArrayList<>();

    @Override
    public void accept(double value) {
        counter.add(value);
        super.accept(value);
    }

    public Optional<List<Double>> getMode() {

        Map<Double, Long> collect = counter.stream().collect(groupingBy(identity(), counting()));

        if (collect.isEmpty()) return Optional.empty();

        long max = collect.values().stream().max(naturalOrder()).orElse(MAX_VALUE);

        return Optional.of(collect.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(toList()));
    }
}
