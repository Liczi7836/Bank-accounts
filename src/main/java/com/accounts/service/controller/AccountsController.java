package com.accounts.service.controller;

import com.accounts.service.domain.Accounts;
import com.accounts.service.domain.AccountsDto;
import com.accounts.service.domain.Customer;
import com.accounts.service.domain.CustomerDto;
import com.accounts.service.mapper.AccountsMapper;
import com.accounts.service.mapper.CustomerMapper;
import com.accounts.service.services.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final DbService dbService;
    private final AccountsMapper accountsMapper;
    private final CustomerMapper customerMapper;

    public List<AccountsDto> getAccounts(){
        return new ArrayList<>();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AccountsDto> getAccount(@PathVariable Long id) throws AccountsNotFoundException{
        return ResponseEntity.ok(accountsMapper.mapToAccountsDto(dbService.getAccountBy(id)));
    }

    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) throws CustomerNotFoundException{
        return ResponseEntity.ok(customerMapper.mapToCustomerDto(dbService.getCustomerBy(id)));
    }


}
