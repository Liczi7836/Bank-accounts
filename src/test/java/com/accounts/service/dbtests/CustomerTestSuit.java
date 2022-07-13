package com.accounts.service.dbtests;

import com.accounts.service.domain.Accounts;
import com.accounts.service.domain.Customer;
import com.accounts.service.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CustomerTestSuit {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testCustomerSavedWithAccount(){
        //Given
        Accounts accounts = new Accounts(
                1421L, "72249000059957936727967706", "PLN", 6525.11
        );
        Customer customer = new Customer(12345L, "Jan", "Kowalski");
        customer.getAccounts().add(accounts);
        accounts.setCustomer(customer);

        //When
        customerRepository.save(customer);
        Long id = customer.getId();

        //Then
        assertEquals(12345L, id);
    }
}
