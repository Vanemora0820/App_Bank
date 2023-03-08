package com.moritabank.app.repository;

import com.moritabank.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByAccountId(Long Account);
    Account findByidClient( Long clientId)

;}
