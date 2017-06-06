package br.com.blz.java8lecture.collectors;

import br.com.blz.java8lecture.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static br.com.blz.java8lecture.service.FidelityService.isDifal;
import static com.google.common.collect.Sets.immutableEnumSet;
import static java.util.stream.Collector.Characteristics.UNORDERED;

public class DifalCollector implements Collector<Order, List<Order>, List<Order>> {

    public static DifalCollector toDifal() {
        return new DifalCollector();
    }

    @Override
    public Supplier<List<Order>> supplier() {
        //() -> new ArrayList<>()
        System.out.println("Supplier");
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Order>, Order> accumulator() {
        System.out.println("Accumulator");
        return (list, element) -> {
            if (isDifal(Stream.of(element)))
                list.add(element);
        };
    }

    @Override
    public BinaryOperator<List<Order>> combiner() {
        System.out.println("Combiner");
        return (left, right) -> { left.addAll(right); return left; };
    }

    @Override
    public Function<List<Order>, List<Order>> finisher() {
        System.out.println("Finisher");
        return i -> i;
    }

    @Override
    public Set<Collector.Characteristics> characteristics() {
        System.out.println("Characteristics");
        return immutableEnumSet(UNORDERED);
    }
}
