package com.fz.demoschool.paymentservice.service;

import com.fz.demoschool.paymentservice.dao.AccountDao;
import com.fz.demoschool.paymentservice.entity.Account;
import com.fz.demoschool.paymentservice.event.account.AccountCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountDao accountDao;

    @EventHandler
    public void on(AccountCreatedEvent event) {
        log.info("Saving account details in database : {}", event);
        accountDao.save(Account.builder()
                .accountId(event.getAccountId())
                .accountHolderName(event.getAccountHolderName())
                .build());
    }
}
