package com.accounts.service.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

public class AccountsDto {

    private Long id;

    private String nrb;

    private String currency;

    private double availableFunds;

    private Customer customer;

    public AccountsDto(Long id, String nrb, String currency, double availableFunds) {
        this.id = id;
        this.nrb = nrb;
        this.currency = currency;
        this.availableFunds = availableFunds;
    }
}
