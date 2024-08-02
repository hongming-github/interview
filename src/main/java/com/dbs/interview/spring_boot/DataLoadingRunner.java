package com.dbs.interview.spring_boot;

import com.dbs.interview.spring_boot.entity.Customer;
import com.dbs.interview.spring_boot.repository.CustomerRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoadingRunner implements ApplicationRunner {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 100; i++) {
            Faker faker = new Faker();
            customerRepository.save(new Customer(faker.name().fullName(), "male"));
        }
    }
}
