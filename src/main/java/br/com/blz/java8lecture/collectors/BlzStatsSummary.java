package br.com.blz.java8lecture.collectors;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.DoubleStream;

import static java.lang.Long.MAX_VALUE;
import static java.util.Collections.emptyList;
import static java.util.Comparator.naturalOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class BlzStatsSummary extends DoubleSummaryStatistics {

    private List<Double> items = new ArrayList<>();

    @Override
    public void accept(double value) {
        items.add(value);
        super.accept(value);
    }

    public OptionalDouble getMedian() {
        DoubleStream sortedValues = items.stream().mapToDouble(r -> r).sorted();

        return items.size() % 2 == 0 ? evenSet(sortedValues) : oddSet(sortedValues);
    }

    private OptionalDouble oddSet(DoubleStream sortedValues) {
        return sortedValues.skip(items.size()/2).findFirst();
    }

    private OptionalDouble evenSet(DoubleStream sortedValues) {
        return sortedValues.skip((items.size() / 2) - 1).limit(2).average();
    }

    public List<Double> getMode() {

        Map<Double, Long> valuesCounted = items.stream().collect(groupingBy(identity(), counting()));

        if (valuesCounted.isEmpty()) return emptyList();

        long max = valuesCounted.values().stream().max(naturalOrder()).orElse(MAX_VALUE);

        return valuesCounted.entrySet().stream().filter(e -> e.getValue() == max).map(Entry::getKey).collect(toList());
    }
}
