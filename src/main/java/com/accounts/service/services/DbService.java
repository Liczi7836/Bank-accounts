package com.accounts.service.services;

import com.accounts.service.controller.AccountsNotFoundException;
import com.accounts.service.controller.CustomerNotFoundException;
import com.accounts.service.domain.Accounts;
import com.accounts.service.domain.Customer;
import com.accounts.service.repository.AccountsRepository;
import com.accounts.service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    public List<Accounts> getAllAccounts(){
        return accountsRepository.findAll();
    }

    public Accounts getAccountBy(Long id) throws AccountsNotFoundException {
        return accountsRepository.findById(id).orElseThrow(AccountsNotFoundException::new);
    }

    public Customer getCustomerBy(Long id) throws CustomerNotFoundException {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    public List<Accounts> getAccountByCustomerId(Long id) {
        return accountsRepository.findAllByCustomer_Id(id);
    }


}
