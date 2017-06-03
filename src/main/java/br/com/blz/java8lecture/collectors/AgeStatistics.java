package br.com.blz.java8lecture.collectors;

import br.com.blz.java8lecture.dataset.CustomerDataset;
import br.com.blz.java8lecture.domain.Customer;

import java.util.IntSummaryStatistics;
import java.util.List;

public class AgeStatistics {

    public static void main(String[] args) {

        List<Customer> customers = CustomerDataset.customers(5000);

        IntSummaryStatistics intSummaryStatistics = customers.stream()
                .mapToInt(Customer::getAge)
                .summaryStatistics();

        System.out.println("customer ages statistics: ");
        System.out.println("average: " + intSummaryStatistics.getAverage());
        System.out.println("max: " + intSummaryStatistics.getMax());
        System.out.println("min: " + intSummaryStatistics.getMin());
        System.out.println("count: " + intSummaryStatistics.getCount());
        System.out.println("sum: " + intSummaryStatistics.getSum());

    }

}
