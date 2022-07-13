package com.accounts.service.controller;

import com.accounts.service.domain.Accounts;
import com.accounts.service.domain.AccountsDto;
import com.accounts.service.domain.Customer;
import com.accounts.service.domain.CustomerDto;
import com.accounts.service.mapper.AccountsMapper;
import com.accounts.service.mapper.CustomerMapper;
import com.accounts.service.services.DbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
@RefreshScope
public class AccountsController {

    private final DbService dbService;
    private final AccountsMapper accountsMapper;
    private final CustomerMapper customerMapper;

    @Value("${application.allow-get-accounts}")
    private boolean allowGetAccounts;

    public List<AccountsDto> getAccounts(){
        return new ArrayList<>();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AccountsDto> getAccount(@PathVariable Long id) throws AccountsNotFoundException{
        return ResponseEntity.ok(accountsMapper.mapToAccountsDto(dbService.getAccountBy(id)));
    }

    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) throws CustomerNotFoundException{
        if(!Boolean.valueOf(allowGetAccounts)){
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }
        return ResponseEntity.ok(customerMapper.mapToCustomerDto(dbService.getCustomerBy(id)));
    }


}
