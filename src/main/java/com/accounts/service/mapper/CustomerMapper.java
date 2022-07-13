package com.accounts.service.mapper;

import com.accounts.service.domain.Accounts;
import com.accounts.service.domain.AccountsDto;
import com.accounts.service.domain.Customer;
import com.accounts.service.domain.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerMapper {

    public Customer mapToCustomer(CustomerDto customerDto){
        List<Accounts> accountsList = new ArrayList<>();
        for(AccountsDto accountsDto : customerDto.getAccountsDto()){
            Accounts accounts = new Accounts(accountsDto.getId(), accountsDto.getNrb(), accountsDto.getCurrency(), accountsDto.getAvailableFunds());
            accountsList.add(accounts);
        }
        Customer customer = new Customer(customerDto.getId(), customerDto.getFirstName(), customerDto.getLastName());
        customer.setAccounts(accountsList);
        return customer;
    }

    public CustomerDto mapToCustomerDto(Customer customer){
        List<AccountsDto> accountsDtoList = new ArrayList<>();
        for(Accounts accounts : customer.getAccounts()){
            AccountsDto accountsDto = new AccountsDto(accounts.getId(), accounts.getNrb(),accounts.getCurrency(),accounts.getAvailableFunds());
            accountsDtoList.add(accountsDto);
        }
        CustomerDto customerDto = new CustomerDto(customer.getId(), customer.getFirstName(), customer.getLastName());
        customerDto.setAccountsDto(accountsDtoList);
        return customerDto;
    }
}
