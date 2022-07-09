package com.accounts.service.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    private Long id;
    private List<Accounts> accounts = new ArrayList<>();

    public Customer(Long id) {
        this.id = id;
    }

    public Customer() {

    }

    @Id
    @Column(name = "customerId")
    public Long getId(){
        return id;
    }

    @OneToMany(
            targetEntity = Accounts.class,
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<Accounts> getAccounts(){
        return accounts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }
}
