package com.accounts.service.repository;

import com.accounts.service.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Override
    List<Customer> findAll();

    @Override
    Optional<Customer> findById(Long id);

    @Override
    Customer save(Customer customer);
}
