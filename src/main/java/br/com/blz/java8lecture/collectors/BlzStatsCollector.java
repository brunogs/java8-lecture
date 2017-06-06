package br.com.blz.java8lecture.collectors;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;

import static java.util.Collections.unmodifiableSet;
import static java.util.function.Function.identity;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class BlzStatsCollector implements Collector<Double, BlzStatsSummary, BlzStatsSummary> {

    private final Supplier<BlzStatsSummary> supplier;
    private final BiConsumer<BlzStatsSummary, Double> accumulator;
    private final BinaryOperator<BlzStatsSummary> combiner;
    private final Function<BlzStatsSummary, BlzStatsSummary> finisher;
    private final Set<Characteristics> characteristics;

    public BlzStatsCollector(Supplier<BlzStatsSummary> supplier, BiConsumer<BlzStatsSummary, Double> accumulator,
                             BinaryOperator<BlzStatsSummary> combiner,
                             Function<BlzStatsSummary, BlzStatsSummary> finisher, Set<Characteristics> characteristics) {
        this.supplier = supplier;
        this.accumulator = accumulator;
        this.combiner = combiner;
        this.finisher = finisher;
        this.characteristics = characteristics;
    }

    @Override
    public Supplier<BlzStatsSummary> supplier() {
        return this.supplier;
    }

    @Override
    public BiConsumer<BlzStatsSummary, Double> accumulator() {
        return this.accumulator;
    }

    @Override
    public BinaryOperator<BlzStatsSummary> combiner() {
        return this.combiner;
    }

    @Override
    public Function<BlzStatsSummary, BlzStatsSummary> finisher() {
        return this.finisher;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return this.characteristics;
    }

    public static BlzStatsCollector toBlzStatsCollector(ToDoubleFunction<Double> fn) {
        return new BlzStatsCollector(BlzStatsSummary::new, (r, t) -> r.accept(fn.applyAsDouble(t)),
                (l, r) -> {
                    l.combine(r);
                    return l;
                },
                identity(),
                unmodifiableSet(EnumSet.of(IDENTITY_FINISH)));
    }
}
