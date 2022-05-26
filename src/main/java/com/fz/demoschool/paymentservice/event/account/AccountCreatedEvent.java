package com.fz.demoschool.paymentservice.event.account;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class AccountCreatedEvent {
    private String accountId;
    private String accountHolderName;
}


