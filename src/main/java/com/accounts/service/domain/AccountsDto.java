package com.accounts.service.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {

    private Long id;

    private String nrb;

    private String currency;

    private double availableFunds;
}
