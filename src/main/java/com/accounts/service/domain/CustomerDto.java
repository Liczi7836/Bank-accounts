package com.accounts.service.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CustomerDto {

        public CustomerDto(Long id) {
                this.id = id;
        }

        public Long id;

        public List<AccountsDto> accountsDto = new ArrayList<>();
}
