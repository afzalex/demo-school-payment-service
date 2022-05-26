package com.fz.demoschool.paymentservice.dto.account;

import lombok.Data;

@Data
public class AccountDto {
    private String accountId;
    private String accountHolderName;
    private Integer amount = 0;
}
