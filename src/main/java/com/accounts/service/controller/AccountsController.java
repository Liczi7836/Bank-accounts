package com.accounts.service.controller;

import com.accounts.service.domain.Accounts;
import com.accounts.service.domain.AccountsDto;
import com.accounts.service.mapper.AccountsMapper;
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

    public List<AccountsDto> getAccounts(){
        return new ArrayList<>();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AccountsDto> getAccount(@PathVariable Long id) throws AccountsNotFoundException{
        return ResponseEntity.ok(accountsMapper.mapToAccountsDto(dbService.getAccountBy(id)));
    }

    public void deleteAccount(Long id){
    }

    public AccountsDto updateAccount(AccountsDto accountsDto){
        return new AccountsDto(2L, "2222", "PLN", 1500.00);
    }

    public void createAccount(AccountsDto accountsDto){}

}
