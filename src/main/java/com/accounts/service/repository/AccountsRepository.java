package com.accounts.service.repository;

import com.accounts.service.domain.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {

    @Override
    List<Accounts> findAll();

    @Override
    Optional<Accounts> findById(Long id);

    @Override
    Accounts save(Accounts accounts);
}
