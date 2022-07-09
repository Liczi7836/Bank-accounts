package com.accounts.service.mapper;

import com.accounts.service.domain.Accounts;
import com.accounts.service.domain.AccountsDto;
import org.springframework.stereotype.Service;

@Service
public class AccountsMapper {

    public Accounts mapToAccounts(AccountsDto accountsDto){
        return new Accounts(
                accountsDto.getId(),
                accountsDto.getNrb(),
                accountsDto.getCurrency(),
                accountsDto.getAvailableFunds());
    }

    public AccountsDto mapToAccountsDto(Accounts accounts){
        return new AccountsDto(
                accounts.getId(),
                accounts.getNrb(),
                accounts.getCurrency(),
                accounts.getAvailableFunds()
        );
    }
}
