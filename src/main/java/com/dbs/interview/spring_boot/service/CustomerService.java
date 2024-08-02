package com.dbs.interview.spring_boot.service;

import com.dbs.interview.spring_boot.entity.Customer;
import com.dbs.interview.spring_boot.exception.CustomerNotFoundException;
import com.dbs.interview.spring_boot.model.GetNamesRequest;
import com.dbs.interview.spring_boot.projections.NamesOnly;
import com.dbs.interview.spring_boot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(UUID id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public List<String> getAllCustomerNamesLambda(GetNamesRequest getNamesRequest) {
        int page = getNamesRequest.getPage();
        int size = getNamesRequest.getSize();

        Comparator<String> comparator = getComparator(getNamesRequest.isAscending());

        List<NamesOnly> nameList = customerRepository.findBy();

        List<String> result = nameList.stream()
                .map(NamesOnly::getName)
                .sorted(comparator)
                .skip((long) page * size)
                .limit(size)
                .collect(Collectors.toList());

        return result;
    }

    public List<String> getAllCustomerNamesJPA(GetNamesRequest getNamesRequest) {
        int page = getNamesRequest.getPage();
        int size = getNamesRequest.getSize();

        Pageable sortedByName = PageRequest.of(
                page, size, getSort("name", getNamesRequest.isAscending())
        );
        List<NamesOnly> nameList = customerRepository.findBy(sortedByName);

        List<String> result = nameList.stream()
                .map(NamesOnly::getName)
                .collect(Collectors.toList());

        return result;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    private Comparator<String> getComparator(Boolean isAscending) {
        Comparator<String> comparator;
        if (isAscending) {
            comparator = Comparator.naturalOrder();
        } else {
            comparator = Comparator.reverseOrder();
        }
        return comparator;
    }

    private Sort getSort(String propertyName, Boolean isAscending) {
        Sort sort;
        if (isAscending) {
            sort = Sort.by(propertyName).ascending();
        } else {
            sort = Sort.by(propertyName).descending();
        }
        return sort;
    }
}
