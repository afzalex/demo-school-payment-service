package com.fz.demoschool.paymentservice;

import com.fz.demoschool.paymentservice.dao.AccountDao;
import com.fz.demoschool.paymentservice.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class PaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

    @Autowired
    private AccountDao accountDao;

    @PostConstruct
    public void postConstruct() {
        accountDao.save(Account.builder().accountId(UUID.randomUUID().toString())
                .userName("Mohammad Afzal " + LocalDateTime.now())
                .balance(10000)
                .build());
    }
}
