package com.fz.demoschool.paymentservice.aggregate;

import com.fz.demoschool.paymentservice.command.account.CreateAccountCommand;
import com.fz.demoschool.paymentservice.event.account.AccountCreatedEvent;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
@Slf4j
public class AccountAggregate {

    @AggregateIdentifier
    private String accountId;
    private String accountHolderName;
    private int balance;

    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        AggregateLifecycle.apply(AccountCreatedEvent.builder()
                .accountId(command.getAccountId())
                .accountHolderName(command.getAccountHolderName())
                .build());
    }

    @EventHandler
    public void on(AccountCreatedEvent event) {
        log.info("Going to create account with following details : {}", event);
        this.accountId = event.getAccountId();
        this.accountHolderName = event.getAccountHolderName();
        this.balance = 0;
    }
}
