package com.fz.demoschool.paymentservice.command.account;

import lombok.Builder;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Builder
public class CreateAccountCommand {
    @TargetAggregateIdentifier
    private String accountId;
    private String accountHolderName;
}
