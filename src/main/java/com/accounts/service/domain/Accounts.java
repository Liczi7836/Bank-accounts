package com.accounts.service.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Builder
public class Accounts {


    private Long id;
    private String nrb;
    private String currency;
    private double availableFunds;
    private Customer customer;

    public Accounts(Long id, String nrb, String currency, double availableFunds) {
        this.id = id;
        this.nrb = nrb;
        this.currency = currency;
        this.availableFunds = availableFunds;
    }

    public Accounts() {

    }

    @Id
    @NotNull
    @Column(name = "id", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "nrb")
    public String getNrb() {
        return nrb;
    }

    public void setNrb(String nrb) {
        this.nrb = nrb;
    }

    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "availableFunds")
    public double getAvailableFunds() {
        return availableFunds;
    }

    public void setAvailableFunds(double availableFunds) {
        this.availableFunds = availableFunds;
    }

    @ManyToOne
    @JoinColumn(name = "customerId")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
