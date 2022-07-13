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
    private String firstName;
    private String lastName;
    private List<Accounts> accounts = new ArrayList<>();

    public Customer(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
