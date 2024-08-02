package com.dbs.interview.spring_boot.repository;

import com.dbs.interview.spring_boot.entity.Customer;
import com.dbs.interview.spring_boot.projections.NamesOnly;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    List<NamesOnly> findBy();

    List<NamesOnly> findBy(Pageable pageable);
}
