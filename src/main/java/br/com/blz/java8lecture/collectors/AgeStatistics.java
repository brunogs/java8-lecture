package br.com.blz.java8lecture.collectors;

import br.com.blz.java8lecture.dataset.CustomerDataset;
import br.com.blz.java8lecture.domain.Customer;

import java.util.IntSummaryStatistics;
import java.util.List;

import static java.util.stream.Collectors.summarizingInt;

public class AgeStatistics {

    public static void main(String[] args) {

        List<Customer> customers = CustomerDataset.customers(5000);

        IntSummaryStatistics ageSummary = customers.stream()
                .collect(summarizingInt(Customer::getAge));

        System.out.println("customer ages statistics: ");
        System.out.println("average: " + ageSummary.getAverage());
        System.out.println("max: " + ageSummary.getMax());
        System.out.println("min: " + ageSummary.getMin());
        System.out.println("count: " + ageSummary.getCount());
        System.out.println("sum: " + ageSummary.getSum());

    }

}
