package com.accounts.service.services;

import com.accounts.service.controller.AccountsNotFoundException;
import com.accounts.service.domain.Accounts;
import com.accounts.service.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final AccountsRepository accountsRepository;

    public List<Accounts> getAllAccounts(){
        return accountsRepository.findAll();
    }

    public Accounts getAccountBy(Long id) throws AccountsNotFoundException {
        return accountsRepository.findById(id).orElseThrow(AccountsNotFoundException::new);
    }


}
