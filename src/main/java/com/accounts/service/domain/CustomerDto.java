package com.accounts.service.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Getter
@Entity(name = "customer")
public class CustomerDto {

    @Id
    @GeneratedValue
    private Long id;

    //private List<Accounts> accounts;
}
