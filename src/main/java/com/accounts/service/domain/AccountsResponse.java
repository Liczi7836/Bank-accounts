package com.accounts.service.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Builder
public class AccountsResponse {
    private List<AccountsDto> accounts;

    public AccountsResponse(List<AccountsDto> accounts) {
        this.accounts = accounts;
    }
}
