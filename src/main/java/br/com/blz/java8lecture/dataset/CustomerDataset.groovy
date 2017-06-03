package br.com.blz.java8lecture.dataset

import br.com.blz.java8lecture.domain.Customer

class CustomerDataset {

    static List<Customer> customers(long maxCustomers) {
        Random random = new Random()
        (1..maxCustomers).collect {
            int randomAge = random.nextInt(50) + 10
            new Customer("customer$it", randomAge)
        }
    }
}
