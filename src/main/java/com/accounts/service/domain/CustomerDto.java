package com.accounts.service.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CustomerDto {

        public CustomerDto(Long id, String firstName, String lastName) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
        }

        public Long id;
        public String firstName;
        public String lastName;

        public List<AccountsDto> accountsDto = new ArrayList<>();


}
