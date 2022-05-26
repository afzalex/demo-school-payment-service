package com.fz.demoschool.paymentservice.controller;

import com.fz.demoschool.paymentservice.dto.account.AccountDto;
import com.fz.demoschool.paymentservice.command.account.CreateAccountCommand;
import com.fz.demoschool.paymentservice.dao.AccountDao;
import com.fz.demoschool.paymentservice.entity.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payment/account")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountDao accountDao;
    private final CommandGateway commandGateway;

    @PostMapping
    public Account createAccount(@RequestBody AccountDto account) {
//        return accountDao.save(account.toBuilder().accountId(UUID.randomUUID().toString()).balance(0).build());
        commandGateway.send(CreateAccountCommand.builder()
                .accountId(UUID.randomUUID().toString())
                .accountHolderName(account.getAccountHolderName())
                .build());
        return null;
    }

    @GetMapping
    public List<Account> listAccount() {
        return accountDao.findAll();
    }
}
